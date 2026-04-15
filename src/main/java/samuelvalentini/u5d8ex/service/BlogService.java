package samuelvalentini.u5d8ex.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import samuelvalentini.u5d8ex.entity.Blog;
import samuelvalentini.u5d8ex.exception.NotFoundException;
import samuelvalentini.u5d8ex.playload.BlogPlayload;
import samuelvalentini.u5d8ex.playload.UpdateBlogPlayload;
import samuelvalentini.u5d8ex.repository.BlogRepository;

import java.util.List;

@Service
@Slf4j
public class BlogService {
    private final BlogRepository blogRepository;
    private final AutoreService autoreService;

    public BlogService(BlogRepository blogRepository, AutoreService autoreService) {
        this.blogRepository = blogRepository;
        this.autoreService = autoreService;
    }

    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    public Blog findById(long blogId) {
        return blogRepository.findById(blogId).orElseThrow(() -> new NotFoundException(String.valueOf(blogId)));
    }

    public Blog saveNewBlog(BlogPlayload blogPlayload) {
        Blog blog = new Blog(blogPlayload.getCategoria(), blogPlayload.getTitolo(), blogPlayload.getContenuto(), autoreService.findById(blogPlayload.getAutoreId()));
        return this.blogRepository.save(blog);
    }

    public Blog findByIdAndUpdate(long blogId, UpdateBlogPlayload updateBlogPlayload) {
        Blog found = blogRepository.findById(blogId).orElseThrow(() -> new NotFoundException(String.valueOf(blogId)));
        found.setCategoria(updateBlogPlayload.getCategoria());
        found.setTitolo(updateBlogPlayload.getTitolo());
        found.setContenuto(updateBlogPlayload.getContenuto());
        found.setCover(updateBlogPlayload.getCover());
        found.setTempoDiLettura(updateBlogPlayload.getTempoDiLettura());
        return found;
    }

    public void deleteBlog(long blogId) {
        this.blogRepository.delete(blogRepository.findById(blogId).orElseThrow(() -> new NotFoundException(String.valueOf(blogId))));
    }

}
