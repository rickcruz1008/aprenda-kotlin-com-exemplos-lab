enum class Nivel { BASICO, INTERMEDIARIO, AVANÇADO }

data class Usuario(val nome: String, val idade: Int, val anoInicio: Int){
	val ID : Int get() = hashCode()
}

data class ConteudoEducacional(var nome: String, var duracao: Int = 60, val nivel: Nivel)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    var inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        var list_size = inscritos.size
       
        if (list_size > 0){
            var id = usuario.ID
            for (i in 0 until list_size) {
                if (inscritos[i].ID == id){
                    println("Este usuário já está inscrito")
                    break
                } else {
                    inscritos.add(usuario)
            		println("Usuário inscrito com sucesso!")
                }
            }
        } else {
            inscritos.add(usuario)
            println("Usuário inscrito com sucesso!")
        }

        //TODO("Utilize o parâmetro $usuario para simular uma matrícula (usar a lista de $inscritos).")
    }
    
}

fun main() {
    
    val usuario1 : Usuario = Usuario("Ricardo Souza Cruz", 23, 2018)
    val usuario2: Usuario = Usuario("Bruna Mello Jahrmann", 23, 2018)
    val usuario3 : Usuario = Usuario("Ricardo Souza Cruz", 23, 2018)
    val conteudo1 : ConteudoEducacional = ConteudoEducacional("Cálculo 1", 120, Nivel.BASICO)
    val conteudo2 : ConteudoEducacional = ConteudoEducacional("Física 1", 120, Nivel.BASICO)
    val conteudo3 : ConteudoEducacional = ConteudoEducacional("Laboratório", 60, Nivel.INTERMEDIARIO)
    val lista_conteudos : List<ConteudoEducacional> = listOf(conteudo1, conteudo2, conteudo3)
    
    val fisica : Formacao = Formacao("Licenciatura em Física", lista_conteudos)
    
    fisica.matricular(usuario1)
    fisica.matricular(usuario2)
    fisica.matricular(usuario3)
    println(fisica.inscritos)
    
    //TODO("Analise as classes modeladas para este domínio de aplicação e pense em formas de evoluí-las.")
    //TODO("Simule alguns cenários de teste. Para isso, crie alguns objetos usando as classes em questão.")
}