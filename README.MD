## Setup

# java install 
export JAVA_HOME=/usr/lib/jvm/java-17-openjdk-amd64/
export PATH=$PATH:$JAVA_HOME/bin
echo $JAVA_HOME
(append exports to "~/.bashrc")

# maven commands
mvn archetype:generate
(template #15 for basic project)