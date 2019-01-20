package gtest

import com.google.api.client.googleapis.auth.oauth2.GoogleCredential
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport
import com.google.api.client.googleapis.testing.auth.oauth2.MockGoogleCredential
import com.google.api.client.json.GenericJson
import com.google.api.client.json.jackson2.JacksonFactory
import com.google.api.services.testing.Testing
import com.google.api.services.toolresults.ToolResults

class Main {
    companion object {
        const val applicationName = "gtest"
        const val localhost = "http://localhost:8080"

        val JSON_FACTORY = JacksonFactory.getDefaultInstance()
        private var HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport()

        val toolResults: ToolResults by lazy {
            val builder = ToolResults
                .Builder(HTTP_TRANSPORT, JSON_FACTORY, defaultCredential)
                .setApplicationName(applicationName)
                .setRootUrl(localhost)

            builder.build()
        }

        val defaultCredential = MockGoogleCredential.Builder()
            .setTransport(MockGoogleCredential.newMockHttpTransportWithSampleTokenResponse())
            .build()
        val defaultProjectId = "mock-projectId"

        @JvmStatic
        fun main(args: Array<String>) {
            GenericJson().factory

            toolResults.Projects().initializeSettings(defaultProjectId).execute()
        }
    }
}
