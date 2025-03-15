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
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gizemir.recipebookcompose.ui.theme.RecipeBookComposeTheme

class MainActivity : ComponentActivity() {

    private val recipeList= ArrayList<Recipe>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RecipeBookComposeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
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


