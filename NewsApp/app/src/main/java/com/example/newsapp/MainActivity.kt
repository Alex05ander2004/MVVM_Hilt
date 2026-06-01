package com.example.newsapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newsapp.ui.screens.NewsDetailScreen
import com.example.newsapp.ui.screens.NewsListScreen
import com.example.newsapp.ui.theme.NewsAppTheme
import dagger.hilt.android.AndroidEntryPoint
import java.net.URLDecoder
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

// @AndroidEntryPoint habilita la inyección en esta Activity
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsAppTheme {
                NewsNavGraph()
            }
        }
    }
}

@Composable
fun NewsNavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "news_list") {

        composable("news_list") {
            NewsListScreen(
                onArticleClick = { id, _, _ ->
                    navController.navigate("news_detail/$id")
                }
            )
        }

        composable(
            route = "news_detail/{articleId}",
            arguments = listOf(navArgument("articleId") { type = NavType.IntType })
        ) { backStackEntry ->
            val articleId = backStackEntry.arguments?.getInt("articleId") ?: 0
            NewsDetailScreen(
                articleId = articleId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}