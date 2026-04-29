# Navie_Rag_bot
# 🧠 AI Chatbot with RAG (Spring AI + Vector Database)

A **production-style AI chatbot backend** built using **Spring Boot + Spring AI**, enhanced with **Retrieval-Augmented Generation (RAG)** for context-aware and accurate responses.

---

## 🚀 Features

* 💬 AI-powered chat using OpenAI models
* 🧠 Conversation memory (maintains chat context)
* 🔍 RAG (Retrieval-Augmented Generation) using vector search
* ⚡ Streaming responses using reactive programming (`Flux`)
* 🛡️ AI safeguards and logging
* 📄 Custom knowledge ingestion into vector database
* 🧩 Clean layered architecture (Controller → Service → Config)

---

## 🏗️ Tech Stack

* **Backend:** Java, Spring Boot
* **AI Framework:** Spring AI
* **LLM:** OpenAI (GPT models)
* **Database:** MariaDB (Vector Store)
* **Reactive:** Project Reactor
* **Build Tool:** Maven

---

## 🧠 Architecture

User Query → Chat Service → Vector Search → Context Retrieval → LLM → Response

---

## 📂 Project Structure

```
src/main/java/com/spring/ai/firstproject/
│
├── Config/
│   └── AIConfig.java
├── Service/
│   ├── ChatService.java
│   └── ChatServiceImpl.java
├── helper/
│   └── Helper.java
└── SpringAiApplication.java
```

---

## ⚙️ Key Implementations

### 🔹 Chat Memory

* Uses in-memory chat memory with sliding window
* Maintains last N messages for better conversation continuity

👉 Example: 

---

### 🔹 RAG (Retrieval-Augmented Generation)

* Retrieves relevant context using vector similarity search
* Enhances LLM responses with external knowledge

👉 Example: 

---

### 🔹 Streaming Responses

* Real-time response streaming using `Flux<String>`

👉 Example: 

---

### 🔹 Data Ingestion

* Stores custom knowledge into vector database

👉 Example: 

---

## ▶️ How to Run

1. Clone the repository

```
git clone https://github.com/your-username/your-repo.git
```

2. Configure your API Key

⚠️ Do NOT expose your API key in public repositories

👉 Config file: 

3. Run the application

```
mvn spring-boot:run
```

---

## 🧪 API Example

### POST `/chat`

**Request**

```json
{
  "query": "What is Java?",
  "userId": "123"
}
```

**Response**

```
Java is a platform-independent programming language...
```

---

## 🚀 Future Enhancements

* Add React / Next.js frontend
* Deploy on AWS (EC2 / ECS)
* Add JWT authentication
* Multi-user chat sessions
* Build AI agents with tool-calling

---

## 📌 Why This Project?

This project demonstrates:

* Real-world **AI backend engineering**
* Integration of **LLM + RAG**
* Scalable **Spring Boot architecture**
* Advanced AI concepts like memory, streaming, and vector search

---

## 👨‍💻 Author

**Karthik Bharathapu**
Java Full Stack Developer | Aspiring AI Engineer

---

## ⚠️ Security Note

Remove any API keys from your code before pushing to GitHub.
Use environment variables or `.env` files instead.

---
