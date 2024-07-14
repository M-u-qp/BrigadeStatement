package com.example.brigadestatement

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.brigadestatement.ui.navigation.navgraph.NavGraph
import com.example.brigadestatement.ui.navigation.navgraph.Route
import com.example.brigadestatement.ui.theme.BrigadeStatementTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BrigadeStatementTheme {
                NavGraph(startDestination = Route.AppStartNavigation.route)
            }
        }
    }
}
