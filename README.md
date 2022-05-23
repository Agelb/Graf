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
 
 
 ## Contributing
 Coming soon  