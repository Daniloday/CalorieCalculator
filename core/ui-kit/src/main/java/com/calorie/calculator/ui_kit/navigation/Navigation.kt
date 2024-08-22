package com.calorie.calculator.ui_kit.navigation

import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.SizeTransform
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.ComposeNavigatorDestinationBuilder
import androidx.navigation.get
import androidx.navigation.toRoute
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import java.util.UUID
import kotlin.reflect.KType
import kotlin.reflect.typeOf



inline fun <reified T> getMapOfNavType(): Map<KType, @JvmSuppressWildcards NavType<*>> {
    val obj = object: NavType<T>(isNullableAllowed = false) {
        override fun get(bundle: Bundle, key: String): T? =
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable(key, T::class.java)
            } else {
                @Suppress("DEPRECATION")
                bundle.getParcelable(key)
            }

        override fun put(bundle: Bundle, key: String, value: T) =
            bundle.putParcelable(key, value as Parcelable)

        override fun parseValue(value: String): T = Json.decodeFromString(value)

        override fun serializeAsValue(value: T): String = Json.encodeToString(value)

        override val name: String = UUID.randomUUID().toString()

    }

    return mapOf(typeOf<T>() to obj)
}

inline fun <reified T : Any, reified E> NavGraphBuilder.composable(
    typeMap: Map<KType, @JvmSuppressWildcards NavType<*>> = if (E::class == Parcelable::class) getMapOfNavType<E>() else emptyMap(),
    deepLinks: List<NavDeepLink> = emptyList(),
    noinline enterTransition:
    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? =
        null,
    noinline exitTransition:
    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? =
        null,
    noinline popEnterTransition:
    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    EnterTransition?)? =
        enterTransition,
    noinline popExitTransition:
    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    ExitTransition?)? =
        exitTransition,
    noinline sizeTransform:
    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
    SizeTransform?)? =
        null,
    noinline content: @Composable AnimatedContentScope.(E) -> Unit
) {


    destination(
        ComposeNavigatorDestinationBuilder(
            provider[ComposeNavigator::class],
            T::class,
            typeMap
        ) {
            content.invoke(this, it.toRoute<E>())
        }
            .apply {
                deepLinks.forEach { deepLink -> deepLink(deepLink) }
                this.enterTransition = enterTransition
                this.exitTransition = exitTransition
                this.popEnterTransition = popEnterTransition
                this.popExitTransition = popExitTransition
                this.sizeTransform = sizeTransform
            }
    )
}
