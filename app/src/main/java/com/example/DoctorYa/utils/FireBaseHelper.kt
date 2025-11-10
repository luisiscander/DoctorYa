package com.example.DoctorYa.utils


import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseHelper @Inject constructor() {

    private val auth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }
    val db: FirebaseFirestore by lazy { FirebaseFirestore.getInstance() }
    val storage: FirebaseStorage by lazy { FirebaseStorage.getInstance() }

    //AUTH
    fun currentUserId(): String? = auth.currentUser?.uid

    fun isLoggedIn(): Boolean = auth.currentUser != null

    fun signOut() = auth.signOut()

    suspend fun signInWithEmail(email: String, password: String): AuthResult =
        auth.signInWithEmailAndPassword(email, password).await()

    suspend fun signUpWithEmail(email: String, password: String): AuthResult =
        auth.createUserWithEmailAndPassword(email, password).await()

    suspend fun signInWithGoogle(account: GoogleSignInAccount): AuthResult {
        val credential = GoogleAuthProvider.getCredential(account.idToken, null)
        return auth.signInWithCredential(credential).await()
    }

    fun sendPasswordReset(email: String) =
        auth.sendPasswordResetEmail(email)


    //FIRESTORE
    suspend fun saveDocument(collection: String, id: String, data: Any) {
        db.collection(collection).document(id).set(data).await()
    }

    suspend fun getDocument(collection: String, id: String): Map<String, Any>? {
        val snapshot = db.collection(collection).document(id).get().await()
        return snapshot.data
    }

    suspend fun deleteDocument(collection: String, id: String) {
        db.collection(collection).document(id).delete().await()
    }

    //STORAGE

    suspend fun uploadFile(path: String, bytes: ByteArray): String {
        val ref = storage.reference.child(path)
        ref.putBytes(bytes).await()
        return ref.downloadUrl.await().toString()
    }
}