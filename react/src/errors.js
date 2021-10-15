export function handleAPIError(response) {
    const contentType = response.headers.get("content-type");
    if (contentType && contentType.indexOf("application/json") !== -1) {
        return response.json().then(data => {
            alert(data.message);
        });
    } else {
        return response.text().then(text => {
            alert(text);
        });
    }
}