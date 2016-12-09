# Git and Github

## Git
Git is a peer-to-peer version control system (VCS) that allows a use to, you guessed it, version their code. Because your code is versioned, you can roll back to another version if so needed. Think of all the times you created

    myHomework.java
    myHomework2.java
    myHomework3.java
    
Git will remove that mess forever. 



### Basic Git usage
Without the desktop toolkit, there are four basic commands you should know plus 2 basic setup commands.

#### Setup Commands
Either you are creating a new git repository or you are using an existing one. Lets first look at setting up a new one since it is the simplest.

In your projects root directory, simply type

    git init
    
That's it. You can now use version control. One caveat, if you are creating a new repository and want to push it to a remote one, e.g. github, you will need that repositories url. Imagine your repository is `https://github.com/yournamehere/myrepo.git`, you would need to add a `remote` with

    git remote add origin https://github.com/yournamehere/myrepo.git
   


If you wish to use an existing repository on a different computer (one where it has never been before), you can `clone` the repository. For instance to clone the csp206 repository (which you're free and encouraged to do), simply type 

    git clone https://github.com/anthonykulis/cps206.git
    
This will create in your current working directory a directory named `cps206` that has everything I have online on your local computer. 

 

#### Add
Adding in git allows you to tell git that whatever file you added should be versioned. Typically you can do this in bulk, but you can also do this file by file. It basic notation is as such

    git add [files]
    
When I use `[]` in command line, it means something is required to replace the `[]`. So as I mentioned, adding in bulk we can use `.` to say "all files in this directory". Example:
    
    git add .
    
This will tell git to add all files in this current directory *downwards* that are not versioned should be added.

Optionally, if you just wanted to add one file, say `myApplication.java`, you could restrict the add feature as such:

    git add myApplication.java
    
 
#### Commit
Committing a file means that the recently added files, or modified files, are ready to be versioned. To use commit, simply type:

    git commit -am 'my commit message, such as - i fixed a bug here'
 
The `-am` tells git to set the message "my commit message, such as - i fixed a bug" to the current commit. This way, when reviewing your commits, you can reference why you committed. Make sure to use a good message that means something to you (or another engineer) in the future.

#### Push
Pushing a commit (or multiple commits) means you share your commits with a remote git repository. Since I am assuming your created a github repository named `myrepo` and have set up the remote named `origin` in the setup steps, to push previously committed code to that repository, simply type

    git push origin master
    
You get a message saying the remote repository is ahead of your local one, this occurred because you changed code somewhere else first and on this local machine it is out of date. Being said, you should always `pull` before you `add` or `commit`

#### Pull
Pulling a commit, or a series of commits, is meant to update your local machine with the "head" of the repository. Before you start any work, (or add and commit if you are in teams on the same repository), you should pull the code down from the remote to your local with

    git pull origin master
    
## Github Desktop For Windows

I am not a windows user. I will update this with a url that demos the above git commands.