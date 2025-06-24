# 🎳 Bowling Score Calculator
A simple Java 21 CLI app to calculate bowling scores frame by frame, including strike, spare, and last-frame logic.

📦 Package Structure

* Frame.java  # Represents a standard bowling frame
* LastFrame.java  # Extends Frame to handle 10th-frame logic
* Game.java # Stores rolls and calculates scores
* GameRunner.java # CLI class that handles user input/output

🔧 Next Steps to Improve
* 🎯 Accept input for each roll from the console.
* 🎯 Create a class ScoreCalculator to incapsulate a counting logic.
*	🧍 Add multiplayer support
*	📝 Validate illegal rolls (e.g. 9 + 5)
*	🖥 Create GUI (JavaFX or Swing)
*	🌐 Add REST API (Spring Boot)
*	💾 Add save/load or export to JSON/CSV

## ▶️ How to Run

## 💻 IntelliJ IDEA

1. **File > New > Project from Existing Sources**
2. Select the folder containing this project.
3. Choose `Gradle` when prompted.
4. Set the SDK to **Java 21**.
5. Open `GameRunner.java` and click the green ▶️ button to run it.

### ✅ Using Gradle

🧪 Run
```bash
./gradlew run 
```

🧪 Run Tests

```bash
./gradlew test
```

