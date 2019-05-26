package palmariuntec.com.br.pocketpersonaltrainer.database

import androidx.room.Database
import androidx.room.RoomDatabase
import palmariuntec.com.br.pocketpersonaltrainer.DAO.AcademiaDAO
import palmariuntec.com.br.pocketpersonaltrainer.DAO.ExercicioDAO
import palmariuntec.com.br.pocketpersonaltrainer.DAO.ExercicioUsuarioDAO
import palmariuntec.com.br.pocketpersonaltrainer.DAO.UsuarioDAO
import palmariuntec.com.br.pocketpersonaltrainer.entidade.*

@Database(version = 1, entities = [Academia::class, Usuario::class, Exercicios::class, ExercicioUsuario::class])

abstract class AcademiaDatabase : RoomDatabase() {

    abstract fun usuarioDAO(): UsuarioDAO
    abstract fun academiaDAO(): AcademiaDAO
    abstract fun exercicioDAO(): ExercicioDAO
    abstract fun exercicioUsuarioDAO():ExercicioUsuarioDAO

}