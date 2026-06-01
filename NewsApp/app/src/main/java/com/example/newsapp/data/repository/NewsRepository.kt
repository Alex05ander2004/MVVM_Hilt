package com.example.newsapp.data.repository

import com.example.newsapp.data.model.Article
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NewsRepository @Inject constructor() {

    fun getTopHeadlines(): List<Article> = fakeArticles

    fun searchNews(query: String): List<Article> {
        return fakeArticles.filter { article ->
            article.title.contains(query, ignoreCase = true) ||
                    article.description.contains(query, ignoreCase = true) ||
                    article.content.contains(query, ignoreCase = true)
        }
    }
    fun getArticleById(id: Int): Article? {
        return fakeArticles.find { it.id == id }
    }

    private val fakeArticles = listOf(
        Article(
            id = 1,
            source = "RPP Noticias",
            author = "Redacción RPP",
            title = "Gobierno peruano anuncia nuevas medidas económicas para el 2025",
            description = "El Ministerio de Economía presentó un paquete de medidas orientadas a reactivar la economía nacional y reducir la informalidad laboral.",
            urlToImage = "https://picsum.photos/seed/news1/800/400",
            publishedAt = "2025-06-01",
            content = "El Ministerio de Economía y Finanzas presentó este lunes un conjunto de medidas económicas destinadas a impulsar el crecimiento del PBI para el presente año. Entre las principales iniciativas se destacan la reducción de trámites burocráticos para pequeñas empresas, incentivos tributarios para el sector turismo y un programa de inversión pública en infraestructura vial en regiones del sur del país. El ministro señaló que se espera un crecimiento de 3.2% para finales de año."
        ),
        Article(
            id = 2,
            source = "El Comercio",
            author = "María López",
            title = "Lima entre las ciudades con mayor crecimiento tecnológico en Latinoamérica",
            description = "Un informe internacional posiciona a Lima en el top 5 de ciudades latinoamericanas con mayor inversión en startups y tecnología.",
            urlToImage = "https://picsum.photos/seed/news2/800/400",
            publishedAt = "2025-05-31",
            content = "Según el informe Tech Cities Latin America 2025, Lima ha escalado posiciones hasta ubicarse en el quinto lugar del ranking de ciudades con mayor ecosistema tecnológico de la región. El crecimiento se explica por el aumento de incubadoras de startups, la llegada de empresas internacionales de tecnología y el fortalecimiento de carreras STEM en universidades locales. Ciudades como São Paulo, Buenos Aires y Ciudad de México lideran el ranking, pero Lima muestra la mayor tasa de crecimiento interanual."
        ),
        Article(
            id = 3,
            source = "Gestión",
            author = "Carlos Mendoza",
            title = "Exportaciones peruanas crecen 12% en el primer trimestre",
            description = "El sector minero y agroexportador lideran el crecimiento de las exportaciones nacionales según cifras de MINCETUR.",
            urlToImage = "https://picsum.photos/seed/news3/800/400",
            publishedAt = "2025-05-30",
            content = "Las exportaciones peruanas registraron un incremento del 12% en el primer trimestre del año, impulsadas principalmente por el sector minero y el agroexportador. El cobre, el oro y la plata continúan siendo los principales productos de exportación, mientras que en el sector agrícola destacan los arándanos, las paltas y los espárragos con destino a mercados de Europa y Asia. MINCETUR destacó que estos resultados reflejan la solidez de los acuerdos comerciales vigentes con más de 20 países."
        ),
        Article(
            id = 4,
            source = "La República",
            author = "Ana Torres",
            title = "Machu Picchu recibe récord de visitantes en temporada alta",
            description = "La ciudadela inca registró más de 5,000 visitantes diarios durante el feriado largo, superando cifras prepandemia.",
            urlToImage = "https://picsum.photos/seed/news4/800/400",
            publishedAt = "2025-05-29",
            content = "Machu Picchu, la joya del turismo peruano, registró un nuevo récord de visitantes durante el último feriado largo con más de 5,000 turistas por día. Las cifras superan los niveles prepandemia y posicionan al santuario histórico como el destino más visitado de Sudamérica en lo que va del año. Las autoridades del Ministerio de Cultura anunciaron la implementación de nuevas medidas de conservación y un sistema de turnos renovado para preservar el patrimonio ante la alta afluencia de turistas nacionales e internacionales."
        ),
        Article(
            id = 5,
            source = "Andina",
            author = "Pedro Quispe",
            title = "Selección peruana convoca a 25 jugadores para eliminatorias",
            description = "El técnico nacional dio a conocer la lista de convocados para los próximos partidos de las eliminatorias sudamericanas al Mundial.",
            urlToImage = "https://picsum.photos/seed/news5/800/400",
            publishedAt = "2025-05-28",
            content = "El comando técnico de la selección peruana de fútbol dio a conocer la lista de 25 jugadores convocados para los próximos compromisos de las eliminatorias sudamericanas rumbo al Mundial 2026. La lista incluye jugadores que militan en el extranjero así como figuras del fútbol local. Entre las novedades destaca el llamado de tres jóvenes valores que vienen teniendo destacadas actuaciones en sus clubes. Los partidos se disputarán en Lima y en condición de visitante en la próxima fecha FIFA."
        ),
        Article(
            id = 6,
            source = "RPP Noticias",
            author = "Sofía Vargas",
            title = "Nuevo hospital de alta complejidad abre en Arequipa",
            description = "El establecimiento de salud más moderno del sur del país inicia operaciones con capacidad para 400 camas y tecnología de punta.",
            urlToImage = "https://picsum.photos/seed/news6/800/400",
            publishedAt = "2025-05-27",
            content = "Arequipa cuenta desde esta semana con un nuevo hospital de alta complejidad que promete transformar la atención médica en el sur del Perú. El nosocomio tiene capacidad para 400 camas, cuenta con 12 quirófanos equipados con tecnología robótica, una unidad de cuidados intensivos de 60 plazas y el primer centro de radioterapia fuera de Lima. La inversión total superó los 280 millones de soles y se espera que atienda a más de 500 pacientes diarios provenientes de Arequipa, Moquegua y Tacna."
        ),
        Article(
            id = 7,
            source = "El Peruano",
            author = "Luis Herrera",
            title = "Congreso aprueba ley de teletrabajo para el sector privado",
            description = "La nueva legislación establece derechos y obligaciones claras para trabajadores y empleadores en modalidad remota.",
            urlToImage = "https://picsum.photos/seed/news7/800/400",
            publishedAt = "2025-05-26",
            content = "El Congreso de la República aprobó por amplia mayoría la nueva Ley de Teletrabajo que regula la modalidad de trabajo remoto en el sector privado. La norma establece que los empleadores deben cubrir los gastos de internet y equipos necesarios para el trabajo desde casa, define un máximo de horas de conexión obligatoria y garantiza el derecho a la desconexión digital fuera del horario laboral. Los especialistas laborales celebraron la aprobación aunque señalaron que aún quedan aspectos de fiscalización por reglamentar."
        ),
        Article(
            id = 8,
            source = "Gestión",
            author = "Roberto Silva",
            title = "BCP y BBVA lanzan billeteras digitales con nuevas funciones",
            description = "Los dos principales bancos del país actualizan sus aplicaciones móviles con pagos instantáneos entre bancos y retiro sin tarjeta.",
            urlToImage = "https://picsum.photos/seed/news8/800/400",
            publishedAt = "2025-05-25",
            content = "El Banco de Crédito del Perú y BBVA Perú anunciaron simultáneamente la actualización de sus plataformas de banca móvil con nuevas funcionalidades orientadas a facilitar los pagos digitales. Entre las novedades destacan las transferencias instantáneas 24/7 sin costo entre cualquier banco del sistema financiero peruano, el retiro de efectivo sin tarjeta en cajeros mediante código QR y la posibilidad de fraccionar compras en establecimientos físicos desde la app. Ambas entidades buscan acelerar la bancarización digital en el país."
        )
    )
}