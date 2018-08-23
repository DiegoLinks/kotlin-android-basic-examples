package com.fourtime.kotlinexamples.myLibrary

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.StaggeredGridLayoutManager
import com.fourtime.kotlinexamples.R
import kotlinx.android.synthetic.main.activity_my_library.*

class MyLibraryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_library)

        //[Cometário em Portugês] Declare seu recycler view com o nome dado no XML

        //Declare your named recycler display in XML
        val recyclerView = recyclerview

        //[Cometário em Portugês] Instanciando o adapter, com o mock (linha 34) e o context

        //Instace adapter, with mock (line 34) and context
        recyclerView.adapter = BookAdapter(books(), this)

        //[Cometário em Portugês] Instanciando o StaggeredGridLayoutManager, apenas para melhorar o desing

        //Instance StaggeredGridLayoutManager, only for best design
        val layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        recyclerView.layoutManager = layoutManager

    }

    //Mock
    private fun books(): List<Book> {
        return listOf(
                Book(1,
                        "https://i.pinimg.com/originals/e0/fc/35/e0fc356885bfdc7c4bf67473475b25bc.jpg",
                        "O Apanhador no Campo de Centeio",
                        "J. D. Salinger",
                        "1951"),
                Book(2,
                        "https://www.livros-digitais.com/images/capas/voltaire-candido.jpg",
                        "Cândido, ou o Otimismo",
                        "Voltaire",
                        "1759"),
                Book(3,
                        "https://images.livrariasaraiva.com.br/imagemnet/imagem.aspx/?pro_id=4891859&qld=90&l=430&a=-1",
                        "O Grande Gatsby",
                        "F. Scott Fitzgerald",
                        "1970"),
                Book(4,
                        "http://imagens.lelivros.love/2014/06/Download-O-Encontro-Marcado-Fernando-Sabino-em-ePUB-mobi-e-pdf.jpg",
                        "Encontro Marcado",
                        "Fernando Sabino",
                        "1956"),
                Book(5,
                        "https://d1pkzhm5uq4mnt.cloudfront.net/imagens/capas/_bbba4875da53942912217769b7a005029445e073.jpg",
                        "O Caso dos Dez Negrinhos",
                        "Agatha Christie",
                        "1939"))
    }
}
