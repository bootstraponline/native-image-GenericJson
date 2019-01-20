# graal broken

Run `./native_build.sh`

Run `./gtest`

Observe

```
./gtest
Exception in thread "main" com.oracle.svm.core.jdk.UnsupportedFeatureError: Accessing an URL protocol that was not enabled. The URL protocol https is supported but not enabled by default. It must be enabled by adding the --enable-url-protocols=https option to the native-image command.
	at com.oracle.svm.core.util.VMError.unsupportedFeature(VMError.java:109)
	at com.oracle.svm.core.jdk.JavaNetSubstitutions.unsupported(JavaNetSubstitutions.java:164)
	at com.oracle.svm.core.jdk.JavaNetSubstitutions.getURLStreamHandler(JavaNetSubstitutions.java:151)
	at java.net.URL.getURLStreamHandler(URL.java:60)
	at java.net.URL.<init>(URL.java:599)
	at java.net.URL.<init>(URL.java:490)
	at java.net.URL.<init>(URL.java:439)
	at com.google.api.client.http.GenericUrl.parseURL(GenericUrl.java:637)
	at com.google.api.client.http.GenericUrl.<init>(GenericUrl.java:115)
	at com.google.api.client.auth.oauth2.Credential$Builder.setTokenServerEncodedUrl(Credential.java:746)
	at com.google.api.client.googleapis.auth.oauth2.GoogleCredential$Builder.setTokenServerEncodedUrl(GoogleCredential.java:832)
	at com.google.api.client.googleapis.auth.oauth2.GoogleCredential$Builder.<init>(GoogleCredential.java:563)
	at com.google.api.client.googleapis.testing.auth.oauth2.MockGoogleCredential$Builder.<init>(MockGoogleCredential.java:58)
	at gtest.Main$Companion$defaultCredential$2.invoke(Main.kt:31)
	at gtest.Main$Companion$defaultCredential$2.invoke(Main.kt:12)
	at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
	at gtest.Main$Companion.getDefaultCredential(Main.kt)
	at gtest.Main$Companion$toolResults$2.invoke(Main.kt:22)
	at gtest.Main$Companion$toolResults$2.invoke(Main.kt:12)
	at kotlin.SynchronizedLazyImpl.getValue(LazyJVM.kt:74)
	at gtest.Main$Companion.getToolResults(Main.kt)
	at gtest.Main$Companion.main(Main.kt:48)
	at gtest.Main.main(Main.kt)
```

Tested on graalvm-ce-1.0.0-rc11/
    