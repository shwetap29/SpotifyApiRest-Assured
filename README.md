# 🎧 Spotify API Automation — REST Assured

> A learning project automating Spotify's Web API using REST Assured (Java) — covering API test automation, endpoint validation, and response verification with a structured QA approach.

---

## 📌 Project Overview

This project was built during my **QA Engineering phase** to learn API test automation using the REST Assured framework. Using Spotify's public Web API as the test target, I automated a series of API calls, validated response structures, and documented test outcomes.

**Honest framing:** This is an early-career learning project from when I was building QA automation skills. It demonstrates the technical and structured thinking I developed before transitioning into Business Analysis — a foundation that now directly informs how I approach UAT, API requirements, and integration testing as a BA.

---

## 🎯 What This Project Covers

- Automating API requests (GET, POST) using REST Assured + Java
- Validating HTTP response codes, response bodies, and headers
- Extracting and asserting specific fields from JSON responses
- Structuring API test cases in a repeatable, maintainable format
- Documenting test results and defect observations

---

## 🔌 API Endpoints Tested

| Endpoint | Method | What Was Validated |
|---|---|---|
| `/v1/artists/{id}` | GET | Artist name, genre, followers returned correctly |
| `/v1/albums/{id}` | GET | Album tracks, release date, artist match |
| `/v1/search` | GET | Search results return correct type and count |
| `/v1/playlists/{id}` | GET | Playlist items, owner, track count |
| Authentication | POST | OAuth token generated and accepted |

---

## 🛠️ Tools & Tech Stack

| Tool | Purpose |
|---|---|
| `Java` | Core programming language |
| `REST Assured` | API automation framework |
| `TestNG` | Test execution and reporting |
| `Maven` | Dependency and build management |
| `Spotify Web API` | Test target (public endpoints) |
| `Postman` | Manual API exploration before automation |

---

## 📁 Repo Structure

```
SpotifyApiRest-Assured/
│
├── src/
│   ├── test/java/        ← Test classes (GET, POST, Auth tests)
│   └── main/java/        ← Helper utilities and base config
├── pom.xml               ← Maven dependencies
├── testng.xml            ← Test suite configuration
└── README.md
```

---

## 💡 Skills Demonstrated

`API Test Automation` · `REST Assured (Java)` · `TestNG` · `JSON Response Validation` · `OAuth Authentication Testing` · `HTTP Methods (GET · POST)` · `Maven` · `Postman` · `Structured QA Thinking`

---

## 📝 What I Learned

- How REST APIs work end-to-end — authentication, request construction, response handling
- How to design maintainable automated test suites (not just one-off scripts)
- Why API validation matters for BA work — specifically for integration requirements and UAT of API-dependent features

---
