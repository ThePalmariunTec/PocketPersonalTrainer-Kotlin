package palmariuntec.com.br.pocketpersonaltrainer.database.services

import palmariuntec.com.br.pocketpersonaltrainer.database.DatabaseManager
import palmariuntec.com.br.pocketpersonaltrainer.entidade.Academia

object AcademiaService {

    fun getAllAcademia(): List<Academia>{
        val dao = DatabaseManager.getAcademiaDAO()
        val academias = dao.findAll()
        return academias
    }

    fun inserir(gym: Academia){
        val dao = DatabaseManager.getAcademiaDAO()
        dao.insert(gym)
    }

}