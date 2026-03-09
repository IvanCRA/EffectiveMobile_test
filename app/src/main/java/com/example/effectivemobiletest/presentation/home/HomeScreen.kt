package com.example.effectivemobiletest.presentation.home

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.effectivemobiletest.presentation.home.components.CourseCard
import com.example.effectivemobiletest.presentation.home.components.SearchAndFilterSection
import com.example.effectivemobiletest.presentation.home.components.SortSection

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    when {
        state.isLoading -> {
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = "Загрузка...",
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(horizontal = 24.dp),
                )
            }
        }

        state.error != null -> {
            Column(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.Center,
            ) {
                Text(
                    text = state.error ?: "Ошибка",
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(horizontal = 24.dp),
                )
            }
        }

        else -> {
            LazyColumn(
                modifier =
                    Modifier
                        .fillMaxSize()
                        .background(MaterialTheme.colorScheme.background),
                contentPadding =
                    PaddingValues(
                        start = 24.dp,
                        end = 24.dp,
                        top = 20.dp,
                        bottom = 100.dp,
                    ),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                item {
                    SearchAndFilterSection()
                }

                item {
                    Spacer(modifier = Modifier.height(8.dp))
                    SortSection(
                        onSortClick = viewModel::onSortByDateClick,
                    )
                }

                items(
                    items = state.courses,
                    key = { it.id },
                ) { course ->
                    CourseCard(
                        course = course,
                        onFavoriteClick = {
                            viewModel.onFavoriteClick(course)
                        },
                    )
                }
            }
        }
    }
}
