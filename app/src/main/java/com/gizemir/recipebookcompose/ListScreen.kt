package com.gizemir.recipebookcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.gizemir.recipebookcompose.ui.theme.RecipeBookComposeTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
//Listenin tamamı
fun RecipeList(recipes: List<Recipe>) {
    //LISTE
    LazyColumn(contentPadding =  PaddingValues(10.dp),
        modifier = Modifier.fillMaxSize()
            //liste tüm ekranı kaplasın(fillmaxsize)

              .background(color= MaterialTheme.colorScheme.primary)
    ) {
        items(recipes){
            RecipeRow(recipe = it)
        }

    }
}

@Composable
//Listenin her bir elemanını tasarlıyoruz (, xml'deki item_row gibi)
fun RecipeRow(recipe: Recipe) {
    Column (modifier = Modifier.fillMaxWidth()
        .background(color= MaterialTheme.colorScheme.background)
        .clickable {
            //listenin elemanlarına tıklandığında ne olacak(NAVIGASYON)

        }){
            Text(recipe.name,
                style = MaterialTheme.typography.displayLarge,
                color = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Bold
                )


            Text(recipe.description,
                 style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Normal
            )
    }
}
/*
@Preview(showBackground = true)
@Composable
fun RecipeListPreview() {
    RecipeBookComposeTheme {
         val recipeList= ArrayList<Recipe>()
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
        RecipeList(recipeList)
    }


}  */