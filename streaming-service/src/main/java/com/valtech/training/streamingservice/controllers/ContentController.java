package com.valtech.training.streamingservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.valtech.training.streamingservice.services.MovieService;
import com.valtech.training.streamingservice.services.WebSeriesService;
import com.valtech.training.streamingservice.vos.MovieVO;
import com.valtech.training.streamingservice.vos.WebSeriesVO;

@RestController
@RequestMapping("/api/v1/content")
public class ContentController {
	
	@Autowired
	private WebSeriesService webSeriesService;
	
	@Autowired
	private MovieService movieService;
	
	@PostMapping("/movies")
	public MovieVO createMovie(@RequestBody MovieVO mvo) {
		return movieService.createOrUpdate(mvo);
	}
	
	@GetMapping("/movies")
	public List<MovieVO> getAllMovies() {
		return movieService.getAllMovies();
	}
	
	@GetMapping("/movies/genre/{genre}")
	public List<MovieVO> getAllMoviesByGenre(@PathVariable("genre") String genre){
		return movieService.getAllMovies();
	}
	
	@GetMapping("/movies/genre/{genre}/language/{language}")
	public List<MovieVO> getAllMoviesByGenreAndLanguage(@PathVariable("genre") String genre, @PathVariable("language") String language){
		return movieService.getMoviesByGenreAndLanguage(genre, language);
	}
	
	@PostMapping("/webseries")
	public WebSeriesVO saveWebSeries(@RequestBody WebSeriesVO vo) {
		return webSeriesService.createOrUpdate(vo);
	}
	
	@GetMapping("/webseries/{id}")
	public WebSeriesVO getWebSeries(@PathVariable("id") long id) {
		return webSeriesService.getWebSeries(id);
	}
	
	@GetMapping("/webseries")
	public List<WebSeriesVO> getAllWebSeries() {
		return webSeriesService.getAllWebSeries();
	}
	
	@GetMapping("/webseries/episodecount/{episodeCount}")
	List<WebSeriesVO> getAllByEpisodeCount(@PathVariable("episodeCount") int episodecount){
		return webSeriesService.getAllByEpisodeCount(episodecount);
	}
	
	@GetMapping("/webseries/episodeDuration/{episodeDuration}")
	List<WebSeriesVO> getAllByEpisodeDuration(@PathVariable("episodeDuration") int episodeDuration){
		return webSeriesService.getAllByEpisodeDuration(episodeDuration);
	}
	
}
