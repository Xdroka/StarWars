package com.starwars

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.google.gson.JsonSyntaxException
import com.starwars.base.BaseFragment
import com.starwars.data.remote.service.FILMS_MEDIA_ENDPOINT
import com.starwars.domain.model.Film
import com.starwars.ui.extensions.fromGson
import com.starwars.ui.extensions.loadUrl
import kotlinx.android.synthetic.main.fragment_film_details.*
import java.text.DateFormat
import java.util.*

class FilmDetailsFragment : BaseFragment() {
    private val args: FilmDetailsFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_film_details, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillFilmDetails()
    }

    private fun fillFilmDetails() {
        val film: Film = try {
            args.film.fromGson<Film>() ?: return
        } catch (e: JsonSyntaxException) { handleErrors(e); return }
        filmDetailsImageView.loadUrl(FILMS_MEDIA_ENDPOINT.format(film.id))
        titleFilmDetailsTv.text = film.title
        val df = DateFormat.getDateInstance(DateFormat.LONG, Locale("pt"))
        dateFilmDetailsTv.text = getString(R.string.launch_date_format).format(df.format(film.releaseDate))
        directorDetailsFilmTv.text = getString(R.string.director_format).format(film.director)
        producerDetailsFilmTv.text = getString(R.string.producer_format).format(film.producer)
    }
}
