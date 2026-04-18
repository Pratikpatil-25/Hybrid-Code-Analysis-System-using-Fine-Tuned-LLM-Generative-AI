package com.onkar;
class Base
{
	
}

class Derived
{
	Derived d = new Derived();
}

public class FieldPolymorphism {
	public static void main(String[] args) {
		Derived d = new Derived();
	}
}


---

### 💡 Your Code:

```java
class Base {
	
}

class Derived {
	Derived d = new Derived();
}
```

---

### 🔍 What happens here

1. When you create an object of `Derived`,
   → the **constructor (default one)** is called.

2. Inside the class definition, there’s a **field**:

   ```java
   Derived d = new Derived();
   ```

   That means:
   Every time you make a new `Derived`, it tries to create **another new `Derived`** to assign to `d`.

3. But that **inner `Derived`** also tries to create another `Derived` inside it… and so on… infinitely!

---

### ⚠️ Result

This causes **infinite recursion in object creation**, leading to:

```
Exception in thread "main" java.lang.StackOverflowError
```

Because the **stack memory** runs out due to infinite constructor calls.

---

### ✅ Correct Understanding

The line:

```java
Derived d = new Derived();
```

is **not “illegal” syntax**, but **logically wrong**, because it keeps creating new `Derived` objects endlessly.

---

### ✅ How to fix it

If you just want a reference (not immediate creation), write:

```java
class Derived {
    Derived d; }
```

Or if you want to initialize it **later**, do it inside a method, not during field declaration:

```java
class Derived {
    Derived d;

    void create() {
        d = new Derived();     }
}
```

---

### 🔑 Key takeaway:

* Declaring a field of the **same type** inside a class is fine ✅
* Instantiating it immediately (`new Derived()`) causes **infinite recursion** ❌

---