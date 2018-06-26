import React, { Component } from 'react';
import {
  AppRegistry,
  Button,
  StyleSheet,
  Text,
  View
} from 'react-native';
import Analytics, { AnalyticsConstants } from 'react-native-analytics-segment-io';

class example extends Component {

  render() {
    return (
      <View style={styles.container}>
        <Text style={styles.welcome}>
          {`React Native Analytics Segment IO`}
        </Text>
        <Text style={styles.instructions}>
          {`Remember to add your own segment key, before running this example.`}
        </Text>
        <Button onPress={() => Analytics.track('button pressed')} title="Press to track" style={styles.button}/>
      </View>
    )
  }
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    backgroundColor: '#F5FCFF',
  },
  welcome: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },
  instructions: {
    textAlign: 'center',
    color: '#333333',
    margin: 10,
  },
  button : {
    margin: 10
  }
})

AppRegistry.registerComponent('example', () => example)
