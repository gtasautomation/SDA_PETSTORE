pipeline 'deployappuntar', {
  description = ''
  disableMultipleActiveRuns = '0'
  disableRestart = '0'
  enabled = '1'
  overrideWorkspace = '0'
  projectName = 'Dinesh'
  skipStageMode = 'ENABLED'

  formalParameter 'ec_stagesToRun', {
    expansionDeferred = '1'
    required = '0'
  }

  stage 'Stage 1', {
    description = ''
    colorCode = '#00adee'
    completionType = 'auto'
    pipelineName = 'deployappuntar'
    resourceName = 'local'
    waitForPlannedStartDate = '0'

    gate 'PRE', {
      }

    gate 'POST', {
      }

    task 'stopapp', {
      description = ''
      actualParameter = [
        'commandToRun': '''/stop-flow.sh
''',
      ]
      advancedMode = '0'
      allowOutOfOrderRun = '0'
      alwaysRun = '0'
      enabled = '1'
      errorHandling = 'continueOnError'
      insertRollingDeployManualStep = '0'
      resourceName = 'local'
      skippable = '0'
      subpluginKey = 'EC-Core'
      subprocedure = 'RunCommand'
      taskType = 'COMMAND'
      useApproverAcl = '0'
      waitForPlannedStartDate = '0'
    }

    task 'clean old', {
      description = ''
      actualParameter = [
        'commandToRun': 'rm -rf flow-1.0',
      ]
      advancedMode = '0'
      allowOutOfOrderRun = '0'
      alwaysRun = '0'
      enabled = '1'
      errorHandling = 'continueOnError'
      insertRollingDeployManualStep = '0'
      resourceName = ''
      skippable = '0'
      subpluginKey = 'EC-Core'
      subprocedure = 'RunCommand'
      taskType = 'COMMAND'
      useApproverAcl = '0'
      waitForPlannedStartDate = '0'
    }

    task 'get', {
      description = ''
      actualParameter = [
        'artifactId': 'flow',
        'classifier': '',
        'config': 'nexus',
        'destination': '/flowapp',
        'extension': 'tar',
        'groupId': 'com.flow.tech',
        'latestVersion': '0',
        'overwrite': '1',
        'repository': 'flow',
        'repoType': 'maven',
        'resultPropertySheet': '',
        'version': '1.0',
      ]
      advancedMode = '0'
      allowOutOfOrderRun = '0'
      alwaysRun = '0'
      enabled = '1'
      errorHandling = 'stopOnError'
      insertRollingDeployManualStep = '0'
      resourceName = 'local'
      skippable = '0'
      subpluginKey = 'EC-Nexus'
      subprocedure = 'Retrieve Artifact from Nexus'
      taskType = 'PLUGIN'
      useApproverAcl = '0'
      waitForPlannedStartDate = '0'
    }

    task 'untar', {
      description = ''
      actualParameter = [
        'commandToRun': '/flowapp/tar -xvf flow-1.0.Tar',
      ]
      advancedMode = '0'
      allowOutOfOrderRun = '0'
      alwaysRun = '0'
      enabled = '1'
      errorHandling = 'stopOnError'
      insertRollingDeployManualStep = '0'
      resourceName = ''
      skippable = '0'
      subpluginKey = 'EC-Core'
      subprocedure = 'RunCommand'
      taskType = 'COMMAND'
      useApproverAcl = '0'
      waitForPlannedStartDate = '0'
    }

    task 'start app', {
      description = ''
      actualParameter = [
        'commandToRun': '/flowapp/bin/start-flow.sh',
      ]
      advancedMode = '0'
      allowOutOfOrderRun = '0'
      alwaysRun = '0'
      enabled = '1'
      errorHandling = 'stopOnError'
      insertRollingDeployManualStep = '0'
      resourceName = ''
      skippable = '0'
      subpluginKey = 'EC-Core'
      subprocedure = 'RunCommand'
      taskType = 'COMMAND'
      useApproverAcl = '0'
      waitForPlannedStartDate = '0'
    }
  }

  // Custom properties

  property 'ec_counters', {

    // Custom properties
    pipelineCounter = '2'
  }
}