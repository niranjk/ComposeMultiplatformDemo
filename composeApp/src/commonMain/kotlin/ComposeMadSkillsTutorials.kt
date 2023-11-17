import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material.BottomAppBar
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource

@OptIn(ExperimentalResourceApi::class)
@Composable
fun MadSkillsTakeItEasyLayout(){
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painterResource("compose-multiplatform.xml"),
            null
        )
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "Mad skills Take it Easy")
            Text(text = "Compose layouts")
        }
    }
}

@Composable
fun MadSkillsArrangementAndAlignment(){
    Column(verticalArrangement = Arrangement.Top, horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Row -- Horizontal Arrangement")
        Row(
            modifier = Modifier.fillMaxWidth(), // helps to take the entire space declared
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Top
        ) {
            ComposerX()
            ComposerX()
        }
        Column(
            modifier = Modifier.fillMaxSize(),  // helps to take the entire space declared
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Column -- Vertical Arrangement")
            ComposerX()
            ComposerX()
        }
    }
}

@Composable
fun MadSkillsBoxLayout(){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            ComposerX()
        }
        Spacer(
            modifier = Modifier.matchParentSize() // do not change the Box's size
                .fillMaxSize() // do not change the Box's size
                .background(color = Color.Yellow.copy(alpha = .3f))
        )
        Text("Overlayed Text")
    }
}


@Composable
fun MadSkillsModifierScopeSafety(){
    Row {
        Spacer(
            modifier = Modifier.weight(1F)
        )
    }
/*
    Box {
        Spacer(
            modifier = Modifier.weight(1F) // not supported
        )
    }
 */
}


@Composable
fun MadSkillsScaffold() {
    var presses by remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = { TopAppBar(title = { Text("Top app bar") }) },
        bottomBar = {
            BottomAppBar(
                contentColor = MaterialTheme.colors.primary,
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                    text = "Bottom app bar",
                    color = Color.White
                )
            }
        },
        floatingActionButton = { FloatingActionButton(onClick = { presses++ }) {
            Icon(Icons.Default.Add, contentDescription = "Add") } }
    ) { innerPadding ->
        Column(
            modifier = Modifier.padding(innerPadding),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = """ You have pressed the floating action button $presses times.""".trimIndent(),
            )
        }
    }
}

@Composable
fun MadSkillsLazyComponent(){
    val alphabets = listOf<String>("A", "B", "C", "D", "E")
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(16.dp)
    ){
        Text("Lazy Column", style = TextStyle(fontWeight = FontWeight.Bold))
        LazyColumn { // add 2 items
            items(2) { index ->
                Text(text = "Item: $index") }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text("Lazy Vertical Grid by 2", style = TextStyle(fontWeight = FontWeight.Bold))
        LazyVerticalGrid(columns = GridCells.Fixed(2)){
            items(alphabets){
                Text(text = it, color =  Color.Red) }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text("Lazy Vertical Staggered Grid", style = TextStyle(fontWeight = FontWeight.Bold))
        LazyVerticalStaggeredGrid(
            columns = StaggeredGridCells.Adaptive(200.dp),
            verticalItemSpacing = 4.dp,
            horizontalArrangement = Arrangement.spacedBy(4.dp),
            content = {
                items(alphabets) { text ->
                    Text(text = text, modifier = Modifier.fillMaxWidth(), color = Color.Blue)
                }
            },
            modifier = Modifier.fillMaxSize()
        )
    }
}


@Composable
fun MadSkillsComposePhases(){
    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center) {
        Icon(Icons.Default.Menu, "menu")
        Row {
            Text("One", modifier = Modifier.padding(10.dp))
            Text("Two", modifier = Modifier.padding(10.dp))
        }
    }
}

@Composable
@OptIn(ExperimentalResourceApi::class)
fun ComposerX(){
    Image(
        painterResource("compose-icon.xml"),
        null
    )
}



