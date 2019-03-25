@file:Suppress("unused")

package com.starwars.data.remote.service

//Base Url
const val BASE_URL = "https://swapi.co/api/"
const val BASE_URL_IMAGE = "https://starwars-visualguide.com/assets/img/"

//PATHS
const val ID_PATH = "id"

//EndPoints
const val SPECIES_ENDPOINT = "species/"
const val CHARACTER_ENDPOINT = "people/"
const val FILMS_ENDPOINT = "films/"

//Media Endpoints
const val SPECIES_MEDIA_ENDPOINT = "${BASE_URL_IMAGE}species/%d.jpg"
const val CHARACTERS_MEDIA_ENDPOINT = "${BASE_URL_IMAGE}characters/%d.jpg"
const val FILMS_MEDIA_ENDPOINT = "${BASE_URL_IMAGE}films/%d.jpg"

//Querys
const val PAGE_QUERY = "page"

//Fields
const val homeWorldField = "homeworld"
const val averageHeightField = "average_height"
const val averageLifeSpanField = "average_lifespan"
const val eyeColorField = "eye_colors"
const val hairColorField = "hair_colors"
const val skinColorField = "skin_colors"
const val birthDayField = "birth_year"
const val noneField = "n/a"
const val episodeIdField = "episode_id"
const val openingCrawlField = "opening_crawl"
const val releaseDateField = "release_date"
const val starShipField = "starships"

// Images from home screen
const val HOME_URL_MEDIA = "https://www.google.com/imgres?imgurl=https%3A%2F%2Fi.pinimg.com%2Foriginals%2F6f%2F75%2F7d%2F6f757dc705b8bc55eddd6abc10e548d1.jpg&imgrefurl=https%3A%2F%2Fwww.pinterest.com%2Fpin%2F836121487039189198%2F&docid=InaYyLr2LOEtqM&tbnid=L-fZo7pPLRNgGM%3A&vet=10ahUKEwjT3MSv_J3hAhWoEbkGHaweBfEQMwg_KAEwAQ..i&w=1920&h=1080&bih=568&biw=1242&q=star%20wars%20full%20hd%20space&ved=0ahUKEwjT3MSv_J3hAhWoEbkGHaweBfEQMwg_KAEwAQ&iact=mrc&uact=8#h=1080&imgdii=L-fZo7pPLRNgGM:&vet=10ahUKEwjT3MSv_J3hAhWoEbkGHaweBfEQMwg_KAEwAQ..i&w=1920"
const val FILMS_URL_MEDIA =
    "https://mondrian.mashable.com/uploads%252Fcard%252Fimage%252F781300%252F4f15f542-e120-4209-9645-1c131144563a.jpg%252F950x534__filters%253Aquality%252890%2529.jpg"
const val SPECIES_URL_MEDIA = "https://starwars-visualguide.com/assets/img/categories/species.jpg"
const val CHARACTERS_URL_MEDIA = "https://hdqwalls.com/download/clone-trooper-star-wars-hd-t1-1920x1080.jpg"