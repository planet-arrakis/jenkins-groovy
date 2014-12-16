## Jenkins-CI Groovy scripts

+ workspace-cleanup.groovy

   Check if a slave has < 10 GB of free space, wipe out workspaces if it does;

+ permissions.groovy

   Grant permissions on many jobs or whole view for many users at once;

+ history_update.groovy

   Update log history settings in jobs, matched by pattern;