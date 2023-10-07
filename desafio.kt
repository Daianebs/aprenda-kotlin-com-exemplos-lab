// [Template original no Kotlin Playground](https://pl.kotl.in/WcteahpyN)
// [Template Daiane no Kotlin Playground] (https://pl.kotl.in/KxvTJZvuo)

enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: String = "1 hr", val nivel: Nivel = Nivel.BASICO)

class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>) {

    val inscritosLista = mutableMapOf<ConteudoEducacional, MutableList<Usuario>>()

    fun matricular(usuario: Usuario, conteudo: ConteudoEducacional) {
        val inscritos = inscritosLista.getOrPut(conteudo) { mutableListOf() }
       if (usuario !in inscritos) {
        inscritos.add(usuario)
    }
    }

    fun listarInscritosPorConteudo() {
        for ((conteudo, inscritos) in inscritosLista) {
            println("________________________________________________")
            println("->Conteúdo: ${conteudo.nome}")
            println("${conteudo.nivel}      ${conteudo.duracao} ")
            println("------------------------------------------------")
            println("Inscritos:")
            for (usuario in inscritos) {
                println("  - ${usuario.nome};")
            }
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução ao Kotlin")
    val conteudo2 = ConteudoEducacional("O Poder das Funções em Kotlin", "2 hrs")
    val conteudo3 = ConteudoEducacional("Tratamento das Excessões em Kotlin", "2 hrs", Nivel.INTERMEDIARIO)

    val formacao = Formacao("Conhecendo a Linguagem de Programação Kotlin", listOf(conteudo1, conteudo2, conteudo2))

    val aluno1 = Usuario("Alice")
    val aluno2 = Usuario("Bruna")
    val aluno3 = Usuario("Carina")

    formacao.matricular(aluno1, conteudo1)
     formacao.matricular(aluno1, conteudo1)//não matricula o mesmo usuario no mesmo curso
    formacao.matricular(aluno2, conteudo2)
    formacao.matricular(aluno3, conteudo1)
    formacao.matricular(aluno3, conteudo3)

    formacao.listarInscritosPorConteudo()
}