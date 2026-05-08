# Object-Oriented Programming with Java

A study companion for the **Object-Oriented Programming with Java** course by **Akin Kaldiroglu**.

For further enquiry please contact Akin Kaldiroglu at akin@kaldiroglu.dev or at https://www.linkedin.com/in/akin-kaldiroglu/

---

## Topics

This is the list of topics for packages under `org.javaturk.oopj`:

* 01: Associations Among Objects
* 02: Inheritance
* 03: Overriding
* 04: final and Sealing
* 05: java.lang.Object Class
* 06: Polymorphism
* 07: instanceof
* 08: Abstract Classes
* 09: Interfaces
* 10: Use of Interfaces
* 11: New Features of Interfaces
* 12: Introduction to Exception Management
* 13: Exception Management in Java
* 14: Introduction to Collections
* 15: Collection Family
* 16: Map Family
* 17: Algorithms, Properties and Other Collection Libraries
* util: Includes only ScannerUtil class

This repo works with JDK 25. Only one class, `org.javaturk.oopj.ch07.factory.downcast.PatternMatchingWithPrimitives`, needs JDK 26.

---

## How to read this codebase

Every chapter package teaches **one** OOP concept. Each chapter is built around small, self-contained examples whose `main` method (a `Test.java` driver) you can run on its own. Read the source first, then run it, then come back and re-read it once you have seen the output.

Three patterns recur throughout. Recognising them will make every chapter easier:

1. **Numbered deltas.** When you see `factory1`, `factory2`, …, `factory5`, or `car1` / `car2` / `car3`, or `calculator1` / `calculator2` / `calculator3`, **only one thing changes between consecutive variants**. Open them in order and look for the single difference — that difference is the lesson.
2. **"Before" and "after" exhibits.** Some packages contain a deliberately bad design (search for `problem1`, `problem2`, `shape1`) right next to the correct one. Compare the two; the bad design exists only to motivate the good one.
3. **Commented-out code is part of the lesson.** Lines that look like dead code are often *intentionally invalid code preserved as compile-error demonstrations*. Try uncommenting them — the compiler error message is the teaching point.

---

## Syllabus and topic map

The course is structured as three triads plus a collections coda:

| Block | Chapters | What you learn |
|---|---|---|
| **Foundations** | ch01–ch05 | Object relationships → inheritance → method override → restricting extension → the `Object` contract |
| **Polymorphism triad** | ch06–ch08 | "You *can* use polymorphism" → "You *need* type interrogation" → "You can *prevent* the ambiguity entirely" |
| **Interface triad** | ch09–ch11 | What interfaces *are* → how to *apply* them → how Java 8/9 *evolved* them |
| **Plumbing coda** | ch13–ch17 | Exceptions → Iterable/Comparable → Collections → Maps → Algorithms |

> **Note:** The original syllabus listed ch12 ("Introduction to Exception Management") as a separate chapter. The material is folded into ch13.

---

## Recurring domain models

Most examples are wired around four small domains. Recognising them up-front saves time:

| Domain | Where it appears | Role |
|---|---|---|
| `Employee → Manager → Director`, plus `Engineer`, `Secretary`, `Boss`, `Worker`, `HR` | ch02, ch03, ch06, ch07, ch08, ch09, ch13.overriding, ch14, ch15, ch16, ch17 | The anchor model. Every concept gets attached to it. |
| `Car`, `F1Car`, plus parts (`Engine`, `Wheel`, `Door`, `Transmission`) | ch01.aggregation, ch01.composition, ch02.encapsulation, ch05.domain | Used to introduce composition, encapsulation, `equals`/`hashCode`. |
| `Shape → Circle / Rectangle / Square / Triangle` | ch04.sealing, ch08.sealing, ch09.shape, ch10.shape, ch13.runtime | Used wherever the lesson is substitutability and invariants. |
| `Document / Printable / XMLDocument` | ch11 (compatibility, defaultMethods, privateMethods, staticMethods) | Used to isolate ch11's variable: same model, different interface feature each time. |

When the same domain reappears in a later chapter, **only one part of it has changed**. Spot the change.

---

## Chapter guide

### ch01 — Associations Among Objects
Two **aggregation** examples (`car/`, `university/`) where independent objects reference each other, and one **composition** example (`composition/`) where `Car` constructs and owns its parts internally. Fields are deliberately package-private — encapsulation is not introduced until ch02.

**Look for:** `Test.java` in `aggregation/` builds a network of independent objects and traverses it via chained references (`student1.coursesTaken[0].teacher.department.name`). `CarTest.java` in `composition/` shows `Car` delegating to internal parts.

### ch02 — Inheritance
The largest chapter. Five `factory*/` iterations of the `Employee/Manager/Director` hierarchy walk you through constructor chaining (`super(...)`), instrumented call-order visibility, an anti-pattern (manual field copying — Turkish comments call this "Kod tekrarı"), the clean version, and finally **deliberately invalid pre-Java 22 code** in `factory5` (validation *before* `super(...)`) — the hook for discussing JEP 482 flexible constructor bodies.

Other highlights: `access/` (the four access modifiers across same vs different package), `encapsulation/car1/car2/car3` (encapsulation decisions in a superclass propagating to subclasses), `hiding/` and `substitutability/` (field hiding and static-method hiding are *not* polymorphic), `init/` (class initialization order — driver code is commented out for whiteboard-style classroom exercises).

### ch03 — Overriding
`factory1/2` reuses the Employee hierarchy, this time with `@Override`. `factory2` shows overrides delegating *upward* with `super.calculateSalary()`. `covariant/` introduces **covariant return types** — `HRForManagers.getAnEmployee()` returns `Manager` instead of `Employee`, a valid override because `Manager extends Employee`.

### ch04 — final Classes and Methods
Three top-level files cover `final` methods (`FinaMethod.java` — yes, that is the filename), `final` classes (`FinalClass.java`), and Oracle's `ChessAlgorithm` example. `sealing/shape/` introduces **JDK 17+ sealed classes**: `Shape sealed permits Circle, Square, Rectangle`, where each permitted subtype picks a different policy — `Circle` is `final`, `Square` is `non-sealed`, `Rectangle` is itself `sealed permits FilledRectangle`. Three policy choices on one slide.

### ch05 — java.lang.Object Class
Five drivers, one per `Object` method: `ToStringExample`, `EqualityExample`, `HashCodeExample`, `CloneExample`, plus `StringEquality` (string pool vs `new String(...)`). `domain/Product.java` overrides the full contract — `equals`, `hashCode`, `toString`, `clone`. `HashCodeExample` deliberately imports `Employee` from ch03 to show what happens *without* the overrides.

### ch06 — Polymorphism
The factory subpackage (`factory/`) introduces upcasting and dynamic dispatch on the HR domain. `factory/problem/problem1` (separate classes, no inheritance) and `factory/problem/problem2` (one god-class with an `int type` field and `if/else if` ladder) are deliberate **antipattern exhibits** — they show what code looks like *before* polymorphism, so the solution in `factory/office/PayrollOffice.paySalary(Employee)` reads as the obvious fix.

`factory/binding/BindingPerformance` benchmarks 2.5 billion iterations of overridable vs `final` class+method, demonstrating JIT inlining gains. This is the practical answer to *why `final` matters*.

### ch07 — instanceof and Casting
`factory/downcast/` walks the entire history of type-narrowing in five files:

| File | JDK | Feature |
|---|---|---|
| `DowncastExample.java` | 1.0 | Plain `(Director) e` and the runtime failures it can produce |
| `InstanceofExample.java` | 1.0 | `instanceof` guard + ordering pitfall (checking `Employee` before `Director`) |
| `InstanceofPatternMatching.java` | 16 | `if (e instanceof Director d)` — pattern variable, scope rules |
| `SwitchPatternMatching.java` | 21 | `switch (employee) { case Director d -> ... }`, `when` guards, dominance ordering |
| `PatternMatchingWithPrimitives.java` | **26** | `if (v instanceof int i)`, primitive patterns in switch |

`fruit/` adds a lighter-weight domain to show the same lesson on a raw (non-generic) `List`: `run1` (blind cast), `run2` (cast on the wrong element — `ClassCastException`), `run3` (`instanceof` guard), `run4` (pattern matching).

### ch08 — Abstract Classes
`Employee.work()` becomes `abstract` — the compiler now closes the loop, so most ch07 `instanceof` checks disappear. The one that remains in `factory/PayrollOffice` (the `instanceof Director` VIP check) is deliberately preserved as the **signal of when `instanceof` is genuinely necessary**.

Two real-world style examples appear here:
- `sorter/` — the cleanest **Template Method** pattern in the codebase. `SimpleSorter` is abstract with `abstract sort()` + concrete `swap()`; three concrete sorters (`Bubble`, `Insertion`, `Selection`) reuse `swap()`; `SorterClient` reassigns to each at runtime.
- `persistence/` — a realistic DAO layer. `Entity → Employee/Product`, `AbstractDao → EmployeeDao/ProductDao`, `EmployeeService` holds the abstraction (dependency injection). `DBConnection.load()` dispatches by `Class.getName()` — intentional bad practice, left for discussion.

`sealing/shape/` revisits the ch04 sealed model, this time layering in abstract methods: the closed type set is also a complete-implementation guarantee.

### ch09 — Interfaces
Three running examples build the foundations:
- `canDo/` — interface naming convention (`Doable`, `Payable`) and the principle that unrelated classes can share a capability without sharing a base class.
- `extending/` — interfaces extending interfaces, including multiple-interface extension (`ABiggerInterface extends AnInterface, AnotherInterface`).
- `factories/factory1`, `factory2`, `factory3` — the HR domain re-implemented around a `Worker` interface; `factory3` adds `Comparable` for natural ordering.

The chapter centerpiece is `flyer/`. A single `SeaPlane extends Airplane implements Floatable` instance is viewed through five reference types (`Vehicle`, `Flyer`, `Floatable`, `Airplane`, `SeaPlane`), and the `driver/` subpackage shows the other side: `Hangar.store(Airplane)`, `Harbour.enter(Floatable)`, `Pilot.drive(Vehicle)` each accept the *same object* through a different "slot." A parallel `animal/` hierarchy (`Eagle extends Bird implements Hunter`, `Bird implements Flyer`) reinforces that unrelated class hierarchies can share an interface.

`Size.java` quietly demonstrates that **enums can implement interfaces** — a point most intro courses skip.

### ch10 — Use of Interfaces
`shape/` is a verbatim copy of `ch09.shape`. The point: same model, different lens — ch09 was about *defining* interfaces, ch10 is about reading the *client code* (`Geometry`, `ShapeTest`) and noticing that nothing about the client cares about concrete shape types.

`callBack/button/` and `callBack/timer/` — the only **callback / Observer** examples in the codebase. Uses Swing `ActionListener` and `javax.swing.Timer`. The framework calls back into your code through the interface.

`math/calculator1/2/3/` — three iterations of the **Strategy** pattern:
- `calculator1` — flat `MathFunction` interface plus concrete strategies.
- `calculator2` — adds `AbstractMathFunction` (Strategy + Template Method together).
- `calculator3` — interface hierarchy: `SingleArgMathFunction` and `DoubleArgMathFunction` model arity as a capability variant.

### ch11 — New Features of Interfaces
A guided tour of Java 8–9 interface evolution:

| Subpackage | Feature | What's new |
|---|---|---|
| `compatibility/` | *motivation* | Why default methods exist — backwards compatibility when evolving an interface |
| `defaultMethods/` | Java 8 | `default void format() { ... }` |
| `multipleInheritance/` (v1) | Java 8 | The diamond problem requires explicit override |
| `multipleInheritance/v2` | Java 8 | Sub-interface "more specific wins"; you can revoke a default by re-declaring it abstract |
| `staticMethods/` | Java 8 | Static interface methods are *not* inherited |
| `privateMethods/` | Java 9 | Private helpers (instance + static) for sharing code between defaults without leaking it |

### ch13 — Exception Management
Notice ch12 is missing — its content lives here.

| Subpackage | Focus |
|---|---|
| `basic/` | The Throwable hierarchy: raising, catching, `Error` vs `Exception`, `StackTraceElement` API |
| `division/` | Unchecked exceptions; polymorphic catch (4 levels); multi-catch |
| `ex/` | Checked exceptions in I/O code, declaration rules, catch-clause ordering, log-and-rethrow |
| `finaly/` | `finally` semantics — yes, it runs even with `return`; runs *between* return-expression and actual return |
| `closable/` and `resource/` | Manual close vs **try-with-resources** — same logic, side by side |
| `overriding/` | **Exception covariance in overrides** — `HRForManagers4`'s body is commented out because `throws Exception` would broaden the parent's `throws NoSuchEmployeeException`. Read those comments. |
| `runtime/shape1` vs `shape2` | The single most important design lesson in ch13 |

`shape1` uses a custom **checked** exception (`NegativeArgumentException extends Exception`), forcing every caller and the factory to wrap or declare. `shape2` replaces it with `IllegalArgumentException` (**unchecked**), so the factory loses ~17 lines. The point: domain invariant violations (negative radius) are programming errors, not recoverable conditions, and unchecked exceptions are the right tool.

### ch14 — Introduction to Collections
`Iterable`, `Iterator`, `Collection`, generics, `Comparable`, `Comparator`. Domain (`domain/`) is the canonical hierarchy: `Person → Employee → Manager → Director`, with `Employee` overriding both `equals()` and `hashCode()` keyed on employee number. **The `equals`/`hashCode` overrides here are load-bearing for ch15 and ch16** — Set membership and Map keying both depend on them.

`util/CollectionUtil` provides pre-built fixtures (lists of `Employee`, `HashSet<String>`, etc.) reused by drivers in ch14, ch15, and ch17.

### ch15 — Collection Family
List, Set, Queue, Deque, plus the legacy `Vector` and `Stack`.
- `hash/HashingExample` reproduces the exact JVM bucket-spreading formula `(h = key.hashCode()) ^ (h >>> 16)` from `HashMap.hash()`.
- `list/ListPerformance` times front-insertion at 100 million elements: ArrayList vs LinkedList vs raw `int[]`. The numbers are the lesson.
- `list/StackExample` — five real algorithms on a Stack: traversal, string reversal, parenthesis balancing, plus a commented-out arithmetic expression evaluator.
- `set/SetWithDuplicatedObjects` — `TreeSet` uses `compareTo`, **not `equals`**, to detect duplicates. Two distinct `Employee` objects with the same `no` collide in the TreeSet. This trips students up; read the file slowly.
- `sequenced/` — Java 21's `SequencedCollection`/`SequencedSet`. Watch for the subtlety: `addFirst(-2)` on a `TreeSet` does *not* place -2 first — sorted order wins.

### ch16 — Map Family
`HashMap`, `TreeMap`, `Hashtable` (legacy), the `Map.Entry` API, and the functional methods (`merge`, `compute`, `computeIfAbsent`, `computeIfPresent`, `replaceAll`) that take `BiFunction` / `BiConsumer` / `Function` lambdas. `MapPerformance` compares 10M insertions HashMap vs TreeMap (O(1) vs O(log n)). `Hashtable` is shown for historical awareness — `Enumeration` API and synchronised-by-default overhead — not as recommended practice.

### ch17 — Algorithms, Properties, Other Libraries
`Collections` static algorithms — `shuffle`, `reverse`, `sort`, `swap`, `binarySearch`, `rotate`, `fill`, `nCopies`, `singletonList`, `unmodifiable*`. `Deal.java` builds a 52-card deck and deals hands using `subList` + `clear`.

`commons/` introduces **Apache Commons Collections 4** — `HashBag` (multiset), `TreeBidiMap` (bidirectional lookup), `MultiValuedMap` (one key, many values), `MultiKeyMap` (tuple keys). These are data structures the JDK lacks.

`properties/` — `java.util.Properties` for configuration. `LoginFrame` is a complete Swing login window where every UI string is loaded from a `.properties` file via `PropertiesUtil`. Demonstrates **internationalisation**: swap the properties file, the entire UI changes — no recompilation.

---

## Tooling notes

- The repo targets **JDK 25**. Only one file — `org.javaturk.oopj.ch07.factory.downcast.PatternMatchingWithPrimitives` — requires **JDK 26** (primitive type patterns). Compile/run that one with the matching JDK and `--enable-preview` if needed.
- Layout is the IntelliJ flat `src/` style — open the project in IntelliJ IDEA and every class with a `main` method has a green "run" gutter icon.
- `util/ScannerUtil` provides a single `static Scanner` over `System.in` exposed as `read(prompt)`. Use it instead of constructing your own `Scanner` — multiple `Scanner` instances on `System.in` is a classic beginner footgun.
- Drivers print to stdout. The output **is** the test. Read it, then compare it against what you expected before the run.

---

## Tips for getting the most out of the codebase

1. **Open numbered series in order.** `factory1` → `factory2` → ... and read with the previous version still in another tab. Spot the diff before reading the comments.
2. **Run `Test.java`/`*Test.java` drivers and read their output.** Many drivers have multiple `runN()` methods — most of them commented out in `main`. Uncomment one at a time.
3. **Trust the commented-out code.** A commented `extends Shape` or `throws Exception` is almost always there to demonstrate a compile error. Try uncommenting and reading the message.
4. **Notice cross-chapter imports.** A few files (e.g. `ch05.HashCodeExample` imports from `ch03.factories.factory1`) deliberately depend on earlier chapters. The earlier chapter must be on the classpath.
5. **When you see a recurring domain, ask: "what changed here?"** That is usually the entire point of the chapter.

---

## Run it with

The project is configured for IntelliJ IDEA with a flat `src/` layout (no Maven/Gradle).

**To run any example from IntelliJ:**
1. Open the project root in IntelliJ IDEA.
2. Ensure the project SDK is JDK 25 (Project Structure → Project → SDK).
3. Navigate to a `Test.java` (or `*Test.java`) file inside any chapter package and click the green ▶ run-gutter icon next to `main`.

**To run from the command line** (replace `<JDK_HOME>` and the class path):

```bash
# From the project root
mkdir -p out
"<JDK_HOME>/bin/javac" -d out -sourcepath src $(find src -name "*.java")
"<JDK_HOME>/bin/java" -cp out org.javaturk.oopj.ch01.composition.CarTest
```

**For the JDK 26 file only**, compile and run with a JDK 26 build and preview flag:

```bash
"<JDK26_HOME>/bin/javac" --enable-preview --release 26 -d out -sourcepath src \
  src/org/javaturk/oopj/ch07/factory/downcast/PatternMatchingWithPrimitives.java
"<JDK26_HOME>/bin/java" --enable-preview -cp out \
  org.javaturk.oopj.ch07.factory.downcast.PatternMatchingWithPrimitives
```

There are no automated tests — every "test" is a `main` method that prints to stdout. Run a driver, read its output, compare against what the source led you to expect.
