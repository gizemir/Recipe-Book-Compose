package com.gizemir.recipebookcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.gizemir.recipebookcompose.ui.theme.RecipeBookComposeTheme
import com.google.gson.Gson

class MainActivity : ComponentActivity() {

    private val recipeList= ArrayList<Recipe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            //stateless(bu nav controller sayesinde navigasyonu yöneteceğiz
            //her yerde süreklü oluşturmak zorunda kalmayalım diye remember kullandık
            val navController = rememberNavController()
            RecipeBookComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        NavHost(navController = navController, startDestination = "list screen") {
                            //sayfalar arası geçiş sırası
                            composable("list screen") {
                                //route ekranına yani list ekranına gidildiğinde hangi sayfanın görüneceği
                                //list screen'e gidildiğinde RecipeList sayfasını göster demek
                                getData()
                                RecipeList(recipeList, navController)
                            }

                            composable("detail screen/{selectedRecipe}",
                                arguments = listOf(
                                    navArgument("selectedRecipe"){
                                        type = NavType.StringType
                                    } )
                            ){
                                val recipeString = remember {
                                    it.arguments?.getString("selectedRecipe")
                                }

                                //sana bir string gelecek, bu stringi recipe sınıfına çevir
                                val selectedRecipe = Gson().fromJson(recipeString, Recipe::class.java)
                                DetailScreen(recipe = selectedRecipe)
                            }


                        }
                    }
                }
            }
        }
    }

    private fun getData(){
        val makarna = Recipe("makarna", "un, su, tuz", R.drawable.makarna)
        val sarma = Recipe("sarma", "yaprak, pirinc, zeytinyagi", R.drawable.sarma)
        val kofte = Recipe("kofte", "et,sogan, tuz", R.drawable.kofte)
        val kisir = Recipe("kisir", "simit, salca, sogan", R.drawable.kisir)
        val dolma = Recipe("dolma", "biber, pirinc, salca", R.drawable.dolma)

        recipeList.add(makarna)
        recipeList.add(sarma)
        recipeList.add(dolma)
        recipeList.add(kofte)
        recipeList.add(kisir)
    }
}



