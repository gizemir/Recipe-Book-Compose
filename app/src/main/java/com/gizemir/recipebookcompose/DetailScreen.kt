package com.gizemir.recipebookcompose

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gizemir.recipebookcompose.ui.theme.RecipeBookComposeTheme

@Composable
//listedeki elemanlara tıklandıktan sonra açılacak olan sayfa
fun DetailScreen(recipe: Recipe) {
    Box(
        modifier = Modifier.fillMaxSize()
            .background(color = MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally){
            Text(recipe.name,
                style = MaterialTheme.typography.displayLarge,
                modifier = Modifier.padding(5.dp),
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Image(bitmap= ImageBitmap.imageResource(id = recipe.image),
                contentDescription = recipe.name,
                modifier = Modifier.padding(16.dp)
            )

            Text(recipe.description,
                style = MaterialTheme.typography.displaySmall,
                modifier = Modifier.padding(5.dp),
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DetailPreview() {
    RecipeBookComposeTheme {

        val makarna = Recipe("makarna", "un, su, tuz", R.drawable.makarna)
        val sarma = Recipe("sarma", "yaprak, pirinc, zeytinyagi", R.drawable.sarma)
        val kofte = Recipe("kofte", "et,sogan, tuz", R.drawable.kofte)
        val kisir = Recipe("kisir", "simit, salca, sogan", R.drawable.kisir)
        val dolma = Recipe("dolma", "biber, pirinc, salca", R.drawable.dolma)

        DetailScreen(recipe = makarna)
    }


}