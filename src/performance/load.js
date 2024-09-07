import http from "k6/http";

export const options = {
    stages: [{
        duration: '12m',
        target: 500
    },
    {
        duration: '20m',
        target: 500
    },
    {
        duration: '4m',
        target: 660
    },
    {
        duration: '4m',
        target: 500
    },
    {
        duration: '20m',
        target: 500
    }
    ]
}

export default function () {
    let response = http.get("http://localhost:3000/customers");
}