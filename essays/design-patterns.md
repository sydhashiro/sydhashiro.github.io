---
layout: essay
type: essay
title: "Design Patterns: Stuff I Was Already Doing, Apparently"
date: 2025-04-24
published: true
labels:
  - Design Patterns
  - Software Engineering
---

## What even *are* design patterns?

Before this module, “design patterns” just sounded like some fancy concept I’d probably never use. But after going through the videos, reading patterns.dev, and looking at the BowFolios project, I realized I’ve already been using a bunch of them without even realizing.

Design patterns are basically reusable solutions to problems that show up a lot when building software. They help keep your code clean and make it easier to work with as your project grows. Once I understood that, everything started to click.

## Turns out, I’ve been using them all along

In Da Grindz, our meal planner app, I used the **Observer Pattern** without even knowing. When a user adds a meal, the macro tracker and planner update right away. In React, that’s just using state and context, but it’s exactly what Observer is meant for. Meteor does this too with publish/subscribe.

I also used the **Factory Pattern** for creating meals. I wrote helper functions that generate new meal objects with all the right info. That’s what factories do—create stuff in a clean, consistent way.

And then there’s **Singleton**. The meal bank and user data in Da Grindz only exist in one place and get reused across the whole app. That’s a Singleton. BowFolios does the same thing with MongoDB collections—each one has a class, and the app just uses one instance of it everywhere.

## Oh, and MVC is here too

Even though I never said, “I’m using MVC,” that’s basically how the app ended up structured:
- **Model**: the planner data and user state
- **View**: React components
- **Controller**: event handlers and custom hooks

In BowFolios, it’s more obvious—MongoDB is the model, Blaze is the view, and FlowRouter handles routing (controller). So yeah, that’s Model-View-Controller in both projects.

## Reactive data, prototypes, and anti-patterns

Meteor and React both use **reactive data**. You change something, and the UI updates. It’s just built in now, but it’s still part of the **Observer Pattern**.

Also, JavaScript is built on the **Prototype Pattern**, even when using `class`. In BowFolios, the way they structure their collection classes makes good use of it.

And then there’s the **Lava Flow anti-pattern**, which basically means scary, messy code no one wants to touch. I’ve definitely seen that before in other projects. Knowing about it now makes me want to avoid writing that kind of code myself.

## Final thoughts

This module helped me realize I’ve been using design patterns without knowing it. Observer, Factory, Singleton, MVC, Prototype—they’re all things I actually used this semester. Now that I know what they are, I can use them better and explain them if someone asks me in an interview.

---

*This essay was written with help from ChatGPT to reflect on my experience using design patterns in ICS 314. All examples and thoughts are based on my own work and what I learned from the course.*
