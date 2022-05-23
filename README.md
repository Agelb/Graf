# Graf
Graf is a graph library containing simple and practical graph implementations and algorithms. 
The purpose of Graf is to provide lightweight types that can be used and extended immediately to solve 
practical problems. Many problems involving combinations, selections, and relationships lend themselves 
to graphs naturally, and graphs help make solving these problems much simpler and more intuitive.

## Design Goals
#### Simple to Use  
The types and interfaces should guide clients on how to use them, as well as what to expect 
in terms of performance (as much as is applicable). Clients must be able to add the dependency to their project, and be 
able to both find what they need and use it as intuitively as possible. Ideally, just a few minutes From updating a 
pom/gradle script to building and using graphs.  
#### Lightweight
This project aims to have as small a jar size as reasonable. External dependencies may be used if
there is a good reason to use them, but effort must be taken to ensure the smallest reasonable dependencies are used.
#### Extendable
Particularly with the kinds of problems graphs are used in, performance is almost always a concern. However, it's
not reasonable for a general-purpose library to be the most performant in all cases. Default implementations are
 provided, but may not be the best performing choice for your use case. To support this, the project uses templated 
 algorithm patterns, so you can provide your own implementations that align with your use cases as needed.  
 For example, in a search, there are several questions to answer:
 1. Do I need to return the entire path between nodes if it exists? Do i just need a yes/no "a path exists"?
 2. Are all traversals valid? Do I have special rules about which traversals can be done? Is there state involved in 
 these decisions?
 3. Is there any place I can short circuit? Do I have some extra domain knowledge to help reduce the searching?  
 4. Where do I plug in my existing logging or instrumentation?  
 
 Graf does not try to answer these questions. Instead, the algorithms are designed so that clients can supply their own
 answers to these questions by implementing various interfaces, and providing these to whatever algorithms are used.
 #### Unopinionated
 This is not a framework, just a simple library with structures and algorithms. The project should not enforce or 
 suggest any particular logging, IO, network, memory model, etc. Clients should be able to drop in the library in their 
 existing projects, whether it's on mobile, spring, EJB, etc, without having to modify their code around the library.
 
 ## Motivation
 There are other graph libraries in java, so why create a new one? There are 3 reasons: simplicity, licensing, and old 
 java versions.  
 There are some fantastic and performant graph projects in java. However, many of them use the GNU license, which in 
 many organizations is not permitted. This project uses the Apache 2.0 license, and commits to using this license as 
 long as the project is active.  
 Second, simplicity. Many simple problems can be solved with just a graph and a search, so there are simple 
 implementations provided out of the box to just solve that problem. Other libraries offer more power and 
 performance, but require learning and brining in additional tools or query languages and patterns. Many of those tools 
 are also designed to handle massive graphs, work with storage backends, handle distributed concerns, etc. This project 
 is just graphs and algorithms. If you've ever looked at a problem, thought "I could knock this out by just checking some paths and constraints",
 this project is for you. If your needs are more "I have billions of nodes and need to find cliques or cycles with complex queries", 
 this may not be (frankly, isn't) the right tool for that.  
 Third, old java. Many of the existing graph libraries, particularly Guava, offer an incredible and rich graph library. 
 However, some of those features require newer java versions or newer versions of Guava, etc. In many organizations, the 
 java versions are set and stuck on older versions for various reasons, or can't update other libraries due to other 
 dependencies or shared code, etc. While those cases are not ideal, development is often not ideal, so this offers a tool
 that can be used for those older systems that can't upgrade for whatever reasons.    
 
 ## Contributing
 Coming soon  