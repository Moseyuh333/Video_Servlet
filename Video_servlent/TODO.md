# TODO List for VideoServlent Project

1. Update pom.xml: Replace PostgreSQL dependency with MySQL connector.
2. Update persistence.xml: Configure for MySQL database (driver, URL, dialect).
3. Create User entity: Add User.java with id, username, password, role.
4. Create DAO layer:
   - AbstractDAO.java for common JPA operations.
   - VideoDAO.java for video CRUD.
   - CategoryDAO.java for category operations.
   - UserDAO.java for user authentication.
5. Create Service layer:
   - VideoService.java for business logic on videos.
   - CategoryService.java for categories.
   - UserService.java for login/register/logout.
6. Create webapp directory structure (src/main/webapp).
7. Create web.xml: Configure servlets, filters (Sitemesh), session.
8. Configure Sitemesh: decorators.xml.
9. Create decorator JSPs: user_decorator.jsp, admin_decorator.jsp.
10. Create JSP pages:
    - login.jsp
    - register.jsp
    - home.jsp (user home)
    - admin.jsp (admin dashboard)
    - video_list.jsp (CRUD with pagination)
    - video_detail.jsp
    - category_videos.jsp
11. Create Servlets:
    - HomeServlet
    - LoginServlet
    - RegisterServlet
    - LogoutServlet
    - VideoServlet (handles CRUD)
    - CategoryServlet
12. Implement all features: login/register/logout, CRUD videos, pagination, details, categories.
13. Critical testing: Test login, CRUD, pagination, views, shares, likes.
14. Deploy: Package WAR and run on Tomcat.
