package com.study.android

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.study.android.ui.theme.AndroidStudyTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

//    // 필드 주입
//    @Inject
//    lateinit var foo:Foo
//
//    // 생성자 주입
//    @Inject
//    lateinit var bar:Bar


    lateinit var foo : Foo
    val TAG : String = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        assert(this::foo.isInitialized) // 초기화 되지 않으면 AssertionError 발생
//        assert(this::bar.isInitialized)
//        assert(foo.bar!=null)
        assert(this::foo.isInitialized)
        setContent {
            AndroidStudyTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    Greeting("Android")
                }
            }
        }
    }

    // 메소드 주입
    @Inject
    fun injectFoo(foo : Foo){
        Log.e(TAG, "injectFoo ${foo.toString()}")
        this.foo = foo
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "집 가고 싶다 $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidStudyTheme {
        Greeting("Android")
    }
}
