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

## So apparently I’ve been using design patterns this whole time?

When I first heard “design patterns,” I thought it was some complicated thing that senior devs or architecture nerds talk about. Turns out I’ve actually been using a bunch of them in my own code without realizing it. This whole module basically made me go, “Ohhh, *that’s* what that’s called.”

Here’s what I learned from the videos, *patterns.dev*, and looking at the BowFolios code, and how it all connects to the Da Grindz app we’ve been building.

## When things update on their own — that’s Observer

In Da Grindz, when I add a meal to the planner, the macro tracker and other parts update automatically. I just thought “yay React state,” but that’s actually the **Observer Pattern**. Same thing in Meteor with publish/subscribe — data changes on the backend, and the frontend updates. Basically, stuff reacts to changes without you having to manually tell every part of the app.

## Making things with helper functions — Factory

I have some functions that create meals or macro data. They do all the setup, formatting, and return everything clean. That’s the **Factory Pattern**. I didn’t call it that, I just wanted to make my code less annoying to manage. In BowFolios, they use `define()` methods for collections and it’s basically the same idea.

## One shared thing for the whole app — Singleton

The meal bank, the macros state, the user info — they all live in one place and get imported wherever I need them. That’s a **Singleton**, I guess. I just thought of it as “don’t duplicate this everywhere.” But yeah, that’s a design pattern too.

## Turns out I’ve been using MVC

I didn’t sit down and plan out Model-View-Controller or anything, but it kind of just happened. In Da Grindz:
- The **model** is the planner state
- The **view** is all the React components
- The **controller** is the event handlers and custom hooks

BowFolios does the same thing, but with MongoDB, Blaze, and FlowRouter. It’s more obvious there, but React apps do it too — just not in your face about it.

## Reactive data and prototypes

Meteor’s whole thing is reactive — when you update the database, the UI updates. That’s built-in Observer stuff. Also, using `useState` and `useEffect` in React is kind of like using reactivity too. We’ve been using that since week one.

Also, JavaScript is built on the **Prototype Pattern**. Even when you write `class`, under the hood it’s all prototype stuff. Didn’t really care before, but now I kinda get why people talk about it.

## Bad patterns: Lava Flow is real

The Lava Flow anti-pattern made me laugh a little because I’ve seen this happen before. Old code that no one touches because everyone’s afraid of breaking something. It just sits there — no one knows why it’s still in the project. I’ve probably written some of that too, honestly. Trying not to do that now.

## Final thoughts

Anyway, I didn’t expect this design pattern stuff to be interesting, but it was. Mostly because it made me realize I’m already using a bunch of them. Observer, Factory, Singleton, MVC, Prototype — I’ve used them all this semester, just didn’t know that’s what they were called. Now that I do, I’m going to be more intentional about it. Also, might help me not sound lost in interviews, which is a plus.

---

*This essay was written with help from ChatGPT to organize my thoughts based on the ICS 314 design pattern lectures and my own work. The examples and voice are all mine.*
