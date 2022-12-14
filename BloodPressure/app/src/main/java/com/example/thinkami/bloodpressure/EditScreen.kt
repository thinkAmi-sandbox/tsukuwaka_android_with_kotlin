package com.example.thinkami.bloodpressure

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.thinkami.bloodpressure.model.WeightRecord
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.time.LocalDateTime


@Composable
fun EditScreen(
    navController: NavController,
    setShowSnackBar: (Boolean) -> Unit,
    setMessage: (String) -> Unit,
    recordId: String
) {
    var weight by rememberSaveable {
        mutableStateOf("")
    }

    if (recordId.isNotEmpty()) {
        LaunchedEffect(Unit) {
            CoroutineScope(Dispatchers.Main).launch {
                withContext(Dispatchers.Default) {
                    val dao = MyApplication.database.weightRecordDao()
                    val record = dao.findById(recordId.toInt())
                    weight = record.weight.toString()
                }
            }
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Weight Record")
                },
                actions = {

                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    IconButton(onClick = { navController.navigate("main") }) {
                        Icon(Icons.Filled.Home, contentDescription = "??????????????????")
                    }
                }
            }
        },
        content = { padding ->
            Column(
                modifier = Modifier.padding(padding)
            ) {
                TextField(
                    value = weight,
                    onValueChange = { weight = it },
                    label = { Text(text = "??????") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )

                Row() {
                    Button(onClick = {
                        // ????????????????????????
                        CoroutineScope(Dispatchers.Main).launch {
                            withContext(Dispatchers.Default) {
                                val dao = MyApplication.database.weightRecordDao()

                                if (recordId.isBlank()) {
                                    dao.insert(WeightRecord(
                                        id = 0,
                                        weight = weight.toInt(),
                                        recordedAt = LocalDateTime.now()))

                                    setMessage("??????????????????")
                                    setShowSnackBar(true)
                                } else {
                                    dao.update(recordId.toInt(), weight = weight.toInt())

                                    setMessage("??????????????????")
                                    setShowSnackBar(true)
                                }
                            }
                        }

                        // ????????????????????????
                        navController.navigate("main")

                    }) {
                        Text("??????")
                    }

                    if (recordId.isNotBlank()) {
                        Spacer(modifier = Modifier.padding(all = 10.dp))

                        Button(onClick = {
                            // ????????????????????????
                            CoroutineScope(Dispatchers.Main).launch {
                                withContext(Dispatchers.Default) {
                                    val dao = MyApplication.database.weightRecordDao()
                                    dao.delete(recordId.toInt())

                                    setMessage("??????????????????")
                                    setShowSnackBar(true)
                                }
                            }

                            // ????????????????????????
                            navController.navigate("main")
                        }) {
                            Text("??????")
                        }
                    }
                }
            }
        },
    )
}
