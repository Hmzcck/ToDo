// package com.hamzacicek.todoapplication.utils.runner;


// import lombok.RequiredArgsConstructor;
// import lombok.extern.log4j.Log4j2;
// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import com.hamzacicek.todoapplication.data.entity.TaskEntity;
// import com.hamzacicek.todoapplication.data.repository.TaskRepository;

// // LOMBOK
// @RequiredArgsConstructor

// // Command Line runner
// @Configuration
// @Log4j2
// public class MainRunner {

//     // INJECTION
//     private final TaskRepository taskRepository;
//     // START
//     public void start(){
//         log.info("###START#######");
//     }
//     // Command Line Runner
//     @Bean
//     public CommandLineRunner blog(){
//      // Lambda Expression
//       return args -> {
//         log.info("Blog Categories");
//           System.out.println("Blog Categories");

//           // Tekil Kategory
//           TaskEntity computerCategory=new TaskEntity();
//           computerCategory.setCategoryName("Bilgisayar");
//           taskRepository.save(computerCategory);

//           // Tekil Kategory
//           TaskEntity tabletCategory=new TaskEntity();
//           tabletCategory.setCategoryName("Tablet");
//           taskRepository.save(tabletCategory);

//           // Blog-1
//           BlogEntity blogEntity=new BlogEntity();
//           blogEntity.getBlogEntityEmbeddable().setHeader("Header-1");
//           blogEntity.getBlogEntityEmbeddable().setContent("Content-1");
//           blogEntity.getBlogEntityEmbeddable().setTitle("Title-1");
//           blogEntity.setRelationCategoryEntity(computerCategory);
//           iBlogRepository.save(blogEntity);

//           // Blog-2
//           BlogEntity blogEntity2=new BlogEntity();
//           blogEntity2.getBlogEntityEmbeddable().setHeader("Header-2");
//           blogEntity2.getBlogEntityEmbeddable().setContent("Content-2");
//           blogEntity2.getBlogEntityEmbeddable().setTitle("Title-2");
//           blogEntity2.setRelationCategoryEntity(computerCategory);
//           iBlogRepository.save(blogEntity2);

//           // Blog-3
//           BlogEntity blogEntity3=new BlogEntity();
//           blogEntity3.getBlogEntityEmbeddable().setHeader("Header-3");
//           blogEntity3.getBlogEntityEmbeddable().setContent("Content-3");
//           blogEntity3.getBlogEntityEmbeddable().setTitle("Title-3");
//           blogEntity3.setRelationCategoryEntity(tabletCategory);
//           iBlogRepository.save(blogEntity3);


//       };
//     }
//     // START
//     public void end(){
//         log.info("###END#######");
//     }
// }