# JobHunt
JobHunt is a simple Spring Boot backend project to manage job postings by admins. It supports CRUD operations on job posts. The system stores job info in a MySQL database and exposes REST APIs for interaction.


JobHunt/
│
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/JobHunt/
│   │   │       ├── controllers/
│   │   │       │   └── PostController.java          # REST API endpoints
│   │   │       ├── dtos/
│   │   │       │   └── PostDto.java                  # Data Transfer Object with validation
│   │   │       ├── exceptions/
│   │   │       │   └── ResourceNotFoundException.java # Custom exceptions
│   │   │       ├── mapper/
│   │   │       │   └── PostMapper.java               # MapStruct interface for DTO-Entity mapping
│   │   │       ├── models/
│   │   │       │   └── Post.java                      # JPA Entity representing DB table
│   │   │       ├── repositories/
│   │   │       │   └── PostRepo.java                  # JPA Repository interface for DB access
│   │   │       ├── services/
│   │   │       │   └── PostService.java               # Business logic layer
│   │   │       ├── Application.java                   # Main Spring Boot Application class
│   │   │       └── config/
│   │   │           └── (Optional Config files)        # Any configuration classes if needed
│   │   └── resources/
│   │       ├── application.yml                         # App config: DB connection, logging
│   │       ├── messages.properties                     # i18n messages (optional)
│   │       └── static/                                 # Static resources if needed
│   └── test/
│       └── java/com/example/JobHunt/
│           └── (Unit & integration tests)
│
├── pom.xml                                            # Maven build & dependencies config
├── README.md                                          # Project overview, setup, and usage guide
└── .gitignore                                         # Files to ignore in Git










  Features

  
🔹 Add New Job Post

🔹 Update/Delete Job Post

🔹 Get All Job Posts

🔹 Search by Location / Experience

🔹 Apply Link Must Be Unique

🔹 Validations via Bean Validation

🔹 DTOs to secure and shape data

🔹 Exception Handling: Global + Custom

🔹 Mapper Layer for Clean Architecture







                    REST APIs
                
Method	            Endpoint	                    Description


GET	               /api/posts	                    Get all job posts
GET	               /api/posts/{id}	              Get job post by ID
POST	             /api/posts	                    Add a job post (admin only)
PUT	               /api/posts/{id}	              Update job post
DELETE	          /api/posts/{id}	                Delete job post
GET	              /api/posts/experience/{exp}    	Filter by experience
GET              	/api/posts/role/{Java}          Filter by role

