package com.example.rst_test.presentaion.blog

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavHostController
import com.example.rst_test.R
import com.example.rst_test.domain.model.SingleBlogUiModel
import com.example.rst_test.presentaion.shared_components.LoadImageFromUrl
import com.example.rst_test.presentaion.shared_components.shimmerEffect

@Composable
fun BlogScreen(navController: NavHostController, idBlog: Int, blogViewModel: BlogViewModel) {

    val blogState = blogViewModel.blogState.collectAsStateWithLifecycle()

    blogViewModel.dispatchIntent(BlogIntent.LoadBlogData(idBlog))

    Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
        when (blogState.value) {
            is BlogState.Exception -> {
                Log.d("BLOG_FETCH_ERROR", (blogState.value as BlogState.Exception).error)
            }

            BlogState.Loading -> {
                BlogShimmer()
            }

            is BlogState.Success -> {
                val blog = (blogState.value as BlogState.Success).data as SingleBlogUiModel
                ConstraintLayout {
                    val (iconButton, view) = createRefs()
                    LoadImageFromUrl(
                        url = blog.image,
                        modifier = Modifier.fillMaxWidth(),
                        scale = ContentScale.None
                    )
                    IconButton(
                        onClick = { navController.popBackStack() },
                        modifier = Modifier
                            .constrainAs(iconButton) {
                                top.linkTo(parent.top, margin = 44.dp)
                                start.linkTo(parent.start, margin = 20.dp)
                            }

                            .background(
                                color = MaterialTheme.colorScheme.background,
                                shape = RoundedCornerShape(48.dp)
                            ),

                        ) {
                        Icon(
                            Icons.Default.ArrowBack,
                            tint = MaterialTheme.colorScheme.onBackground,
                            contentDescription = ""
                        )
                    }
                    Box(
                        modifier = Modifier
                            .background(
                                color = MaterialTheme.colorScheme.background,
                                shape = RoundedCornerShape(100.dp)
                            )
                            .width(24.dp)
                            .height(4.dp)
                            .constrainAs(view) {
                                top.linkTo(parent.top, margin = 8.dp)
                                start.linkTo(parent.start)
                                end.linkTo(parent.end)
                            }

                    )
                }
                Column(modifier = Modifier.padding(top = 16.dp, start = 16.dp, end = 16.dp)) {
                    Text(text = blog.date, style = MaterialTheme.typography.bodySmall)
                    Text(text = blog.title, style = MaterialTheme.typography.headlineLarge)
                    Divider(
                        modifier = Modifier.padding(vertical = 16.dp),
                        color = MaterialTheme.colorScheme.outlineVariant
                    )
                    Text(
                        text = blog.content,
                        style = MaterialTheme.typography.titleLarge,
                    )
                }
            }
        }
    }
}

@Composable
fun BlogShimmer(){
    val darkThem = isSystemInDarkTheme()
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .shimmerEffect(darkThem)
    ) {
        Image(
            painterResource(id = R.drawable.placeholder),
            contentDescription = "",
            modifier = Modifier,
            contentScale = ContentScale.Crop
        )
    }
    Column(Modifier.padding(vertical = 16.dp)) {
        Box(
            modifier = Modifier
                .height(16.dp)
                .width(60.dp)
                .shimmerEffect(darkThem)
                .padding(top = 16.dp)
        )
        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .height(80.dp)
                .fillMaxWidth()
                .shimmerEffect(darkThem)
        )

        Box(
            modifier = Modifier
                .padding(top = 16.dp)
                .height(300.dp)
                .fillMaxWidth()
                .shimmerEffect(darkThem)
        )
    }
}