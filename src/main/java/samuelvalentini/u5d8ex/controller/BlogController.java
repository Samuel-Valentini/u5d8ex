package samuelvalentini.u5d8ex.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import samuelvalentini.u5d8ex.entity.Blog;
import samuelvalentini.u5d8ex.playload.BlogPlayload;
import samuelvalentini.u5d8ex.playload.UpdateBlogPlayload;
import samuelvalentini.u5d8ex.service.BlogService;

import java.util.List;

@RestController
@RequestMapping("/blogPosts")
public class BlogController {
    private BlogService blogService;

    public BlogController(BlogService blogService) {
        this.blogService = blogService;
    }

    @GetMapping
    public List<Blog> findAll() {
        return this.blogService.findAll();
    }

    @GetMapping("/{blogId}")
    public Blog getBlogById(@PathVariable long blogId) {
        return this.blogService.findById(blogId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog createNewBlog(@RequestBody BlogPlayload blogPlayload) {
        return this.blogService.saveNewBlog(blogPlayload);
    }

    @PutMapping("/{blogId}")
    public Blog updateBlog(@PathVariable long blogId, @RequestBody UpdateBlogPlayload updateBlogPlayload) {
        return this.blogService.findByIdAndUpdate(blogId, updateBlogPlayload);
    }

    @DeleteMapping("/{blogId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBlog(@PathVariable long blogId) {
        this.blogService.deleteBlog(blogId);
    }
}
