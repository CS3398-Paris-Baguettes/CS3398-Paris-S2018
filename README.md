# CS3398-Paris-S2018

# Wachit

**Wachit** is a Android application that allows a user to find where their favorite movies and television shows are streaming! The application currently supports functionality for determining whether or not a particular movie or television show is available for streaming on Netflix or Hulu.

# Current functionality
Currently, the core functionality of the application is completed. 
- A user can sign up and create a Wachit account. 
 
- The user can then login using their credentials. 

- They will then be redirected to a search page where they can input a query for any movie or television show they desire. 
-If a service has the requested content, it will state what service the content is available on and provide a link to the desired content. 
-If the service does not have the requested content, Wachit will let the user know that neither Netflix or Hulu host what they are searching for.

# How it works

Apart from the robust GUI Activities, the actual core functionality of Wachit relies on two custom defined classes:

**DatabaseHelper.java** - DatabaseHelper is a custom SQLite database handling class that allows the app to perform necessary function over the user objects created by signing up for Wachit. This database is used for both displaying certain parts of user information and authentication for when a user attempts to log in to Wachit.

**FilmSearcher.java** - FilmSearcher is where all of the searching functionality actually happens. FilmSearcher utilizes Java networking functionality and interacts with the Google Custom Search API in order to make search queries. FilmSearcher contains searchNetflix() and searchHulu() functions that take the user input, passes it to the Google Custom Search API which returns a JSON Object. FilmSearcher then parses the JSON object and picks out 10 relevant links and places them in a list. This list is then searched to see if it contains a URL that is considered signature of the Netflix and Hulu streaming services. If there is a match, a link to the desired film/show is returned and it is decided that that particular service offers the requested content at the returned link.

# Desired future features
The vision for Wachit is one where users can receive recommendations based on search history and share their searches with other users.

That being said, desired future features are

- Successful TravisCI integration to aid in development and unit testing
- A graphical display of thumbnails, ratings and descriptions of searched content
- A more developed user experience where users can interact and receive recommendations

# Project Contributors
- Jarrod Trompler (Sprint 1, 2 and 3)

-- DatabaseHelper

-FilmSearcher

-SearchFragment

-User

-Miscellaneous work on MainActivity/LoginActivity/SignupActivity
 
 
- Roddie Frederik (Sprint 1, 2 and 3)

-UserFragment

-Extensive GUI work

-Optimization / Cleanup

-Miscellaneous work on MainActivity/LoginActivity/SignupActivity
 
 
- Alexander Muyshondt (Sprint 1)

-Miscellaneous work on MainActivity/LoginActivity/SignupActivity

-Created Wachit Logo
