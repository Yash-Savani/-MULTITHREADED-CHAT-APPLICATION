# -MULTITHREADED-CHAT-APPLICATION

*COMPANY*: CODTECH IT SOLUTIONS

*NAME*: YASH SAVANI

*INTERN ID*: CT12WOND

*DOMAIN*: JAVA PROGRAMMING

*DURATION*: 12 WEEKS

*MENTOR*: NEELA SANTHOSH

## DESCRIPTON :
 Task 3: Java Chat Application using Sockets and Multithreading with GUI

### **Purpose of the Task**

The purpose of Task 3 was to build a real-time **chat application** in Java using **Sockets**, **Multithreading**, and a **Graphical User Interface (GUI)**. The task focused on demonstrating how multiple clients can connect to a central server to communicate in real-time. The chat system works on a **client-server architecture**, where the server handles multiple client connections concurrently, and each client can send and receive messages in real-time.

By leveraging **multithreading**, each client operates on its own thread, ensuring that the server can manage many users simultaneously without any delay or blocking. The **GUI** enhances the user experience by providing a visually interactive interface, making the chat system more user-friendly and accessible.

This task allows for the creation of a robust chat application that can be expanded with additional features such as user authentication, private messaging, and more complex message formatting.

---

### **Tools & Technologies Used**

- **Java 17+** – Core language used for development.
- **Java Sockets (java.net.Socket & ServerSocket)** – Used for establishing and managing network connections between clients and the server.
- **Multithreading (java.lang.Thread)** – To handle multiple clients concurrently, each in a separate thread.
- **Java I/O (BufferedReader, PrintWriter)** – For reading and writing messages between clients and the server.
- **Swing (javax.swing)** – For creating the graphical user interface (GUI) of the client application.
- **Eclipse STS (Spring Tool Suite)** – The IDE used for coding, running, and debugging the application.

---

### **Features Implemented**

1. **Multi-Client Communication**  
   The server listens on a specific port and accepts connections from multiple clients. Each client is handled by a separate thread to ensure smooth communication without delays.

2. **Real-Time Message Broadcast**  
   Messages from any client are broadcast to all connected clients in real-time. When one client sends a message, it is immediately displayed on the other clients’ interfaces.

3. **Graphical User Interface (GUI)**  
   The client application includes a **graphical interface** built using **Swing**, providing an intuitive and interactive experience for users. The GUI includes:
   - A **chat area** where messages are displayed.
   - An **input field** for entering messages.
   - **Emoji buttons** for sending emoticons to enhance the chat experience.
   - **Theme toggle** to switch between dark and light modes.

4. **Theme Toggle**  
   The chat application features a **dark mode** by default, which can be toggled to a **light mode** using a button on the interface. This allows users to customize the appearance of the application for better readability and personal preference.

5. **Emoji Support**  
   The client includes a panel of **emojis** that can be inserted into messages, making the conversation more expressive and fun.

6. **Socket Communication**  
   Clients connect to the server using **sockets**, and messages are transmitted via **TCP/IP**. The server broadcasts the messages to all connected clients, enabling group chat functionality.

7. **Graceful Disconnect**  
   When a client disconnects, the server handles the disconnection gracefully and ensures that the client’s connection is properly closed.

---

### **Real-World Applications**

This project has several practical applications, such as:

- **Internal messaging systems** within organizations or teams.
- **Chat features** for social platforms or online games where users need to communicate.
- **Collaborative tools** where real-time text communication is essential, like in virtual classrooms or project management platforms.
- **Networking projects** for educational purposes, particularly for demonstrating **socket programming** and **multithreading**.

The **client-server model** and use of **multithreading** make this application scalable for larger systems where many users are involved, though features like **private messaging** and **user authentication** can be added for future iterations.

---

### **Conclusion**

This chat application in Java, designed with **Sockets** and **Multithreading**, offers a robust foundation for real-time messaging. The **GUI** makes it more user-friendly, while the implementation of **emoji support** and **theme toggling** enhances the chat experience.

Though this version lacks features like **private messaging** or **user authentication**, it serves as a solid base for further improvements and can be expanded into a more comprehensive chat application. This task was an excellent opportunity to apply **network programming** and **concurrency** concepts, which are essential skills in backend and system development.

By completing this project, I gained hands-on experience in building networked applications and handling multiple concurrent connections, which are crucial in developing scalable real-time systems.

![Image](https://github.com/user-attachments/assets/6988d1f1-b412-430e-8851-9d3a0efca944)
