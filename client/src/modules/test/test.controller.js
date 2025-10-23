const TestController = {}
const ENV = import.meta.env

const API_URL = `http://${ENV.VITE_API_HOST}:${ENV.VITE_API_PORT}${ENV.VITE_API_BASE_URL}`

TestController.callToApi = async () => {
    await fetch(`${API_URL}/test`, {
        method: 'GET',
        headers: {
            'Accept': 'application/json',
        }})
        .then(response => response.json())
        .then(data => {
            console.log('Response from API:', data)
        })
        .catch(error => {
            console.error('Error calling API:', error)
        })
}

export default TestController