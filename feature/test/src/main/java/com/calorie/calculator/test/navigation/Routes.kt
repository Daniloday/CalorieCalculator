package com.calorie.calculator.test.navigation

import android.os.Build
import android.os.Bundle
import android.os.Parcelable

import kotlinx.parcelize.Parcelize
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.koin.androidx.scope.scope
import java.util.UUID
import kotlin.reflect.KType
import kotlin.reflect.typeOf

@Serializable
sealed class Routes {
    @Serializable
    data object FirstScreen : Routes()

    @Serializable
    data class SecondScreen(val param: String) : Routes()
}

@Serializable
@Parcelize
data class Trans(
    val enum: String,
) : Parcelable


//public inline fun <reified T : Any, reified E: Parcelable> NavGraphBuilder.composable(
//    typeMap: Map<KType, @JvmSuppressWildcards NavType<*>> = getHui<E>(),
//    deepLinks: List<NavDeepLink> = emptyList(),
//    noinline enterTransition:
//    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
//    EnterTransition?)? =
//        null,
//    noinline exitTransition:
//    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
//    ExitTransition?)? =
//        null,
//    noinline popEnterTransition:
//    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
//    EnterTransition?)? =
//        enterTransition,
//    noinline popExitTransition:
//    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
//    ExitTransition?)? =
//        exitTransition,
//    noinline sizeTransform:
//    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
//    SizeTransform?)? =
//        null,
//    noinline content: @Composable AnimatedContentScope.(NavBackStackEntry) -> Unit
//) {
//
//
//    destination(
//        ComposeNavigatorDestinationBuilder(
//            provider[ComposeNavigator::class],
//            T::class,
//            typeMap,
//            content
//        )
//            .apply {
//                deepLinks.forEach { deepLink -> deepLink(deepLink) }
//                this.enterTransition = enterTransition
//                this.exitTransition = exitTransition
//                this.popEnterTransition = popEnterTransition
//                this.popExitTransition = popExitTransition
//                this.sizeTransform = sizeTransform
//            }
//    )
//}
//
//public inline fun <reified T : Any, reified E: Parcelable> NavGraphBuilder.composable(
//    typeMap: Map<KType, @JvmSuppressWildcards NavType<*>> = getHui<E>(),
//    deepLinks: List<NavDeepLink> = emptyList(),
//    noinline enterTransition:
//    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
//    EnterTransition?)? =
//        null,
//    noinline exitTransition:
//    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
//    ExitTransition?)? =
//        null,
//    noinline popEnterTransition:
//    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
//    EnterTransition?)? =
//        enterTransition,
//    noinline popExitTransition:
//    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
//    ExitTransition?)? =
//        exitTransition,
//    noinline sizeTransform:
//    (AnimatedContentTransitionScope<NavBackStackEntry>.() -> @JvmSuppressWildcards
//    SizeTransform?)? =
//        null,
//    noinline content: @Composable AnimatedContentScope.(E) -> Unit
//) {
//
//
//    destination(
//        ComposeNavigatorDestinationBuilder(
//            provider[ComposeNavigator::class],
//            T::class,
//            typeMap
//        ) {
//            content.invoke(this, it.toRoute<E>())
//        }
//            .apply {
//                deepLinks.forEach { deepLink -> deepLink(deepLink) }
//                this.enterTransition = enterTransition
//                this.exitTransition = exitTransition
//                this.popEnterTransition = popEnterTransition
//                this.popExitTransition = popExitTransition
//                this.sizeTransform = sizeTransform
//            }
//    )
//}

