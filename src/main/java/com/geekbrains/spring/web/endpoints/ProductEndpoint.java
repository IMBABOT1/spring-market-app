package com.geekbrains.spring.web.endpoints;

@Endpoint
@RequiredArgsConstructor
public class ProductEndpoint {
    private static final String NAMESPACE_URI = "http://www.flamexander.com/spring/ws/students";
    private final StudentService studentService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getStudentByNameRequest")
    @ResponsePayload
    public GetPro getStudentByName(@RequestPayload GetStudentByNameRequest request) {
        GetStudentByNameResponse response = new GetStudentByNameResponse();
        response.setStudent(studentService.getByName(request.getName()));
        return response;
    }

    /*
        Пример запроса: POST http://localhost:8080/ws
        Header -> Content-Type: text/xml

        <soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:f="http://www.flamexander.com/spring/ws/students">
            <soapenv:Header/>
            <soapenv:Body>
                <f:getAllStudentsRequest/>
            </soapenv:Body>
        </soapenv:Envelope>
     */

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAllStudentsRequest")
    @ResponsePayload
    public GetAllStudentsResponse getAllStudents(@RequestPayload GetAllStudentsRequest request) {
        GetAllStudentsResponse response = new GetAllStudentsResponse();
        studentService.getAllStudents().forEach(response.getStudents()::add);
        return response;
    }
}


