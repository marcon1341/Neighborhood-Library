The Application allows users to view available books, check out books by entering their name and also see which books are checked out.


![Screenshot 2025-04-18 152647](https://github.com/user-attachments/assets/bc534edd-dd42-47c3-9827-a1bc4bdc0701)



![Screenshot 2025-04-18 154821](https://github.com/user-attachments/assets/dd43f28b-e238-4ce1-8ccd-8de4e8000ba9)


This method helped me learn how to search in an array and avoid errors by checking if the book is null.
It finds a book by its ID and returns it.
  <pre>  
      public static Book findBookById(int id) {
        for (Book book : books) {
            if (book != null && book.getId() == id) {
                return book; // Found the book
            }
        }
        return null; // when No match found
    }
  </pre>
