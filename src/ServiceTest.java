import org.junit.Rule;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;
import static sun.nio.cs.Surrogate.is;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {
    @Rule
    private MockitoRule mockitoRule = MickitoJUnit.rule();

    @Mock
    private StudentDataObject studentDataObject;

    @Mock
    private InstructorDataObject instructorDataObject;

    @Mock
    private ClassDataObject classDataObject;

    @InjectMocks
    private ClientBusinessObjectImpl clientBusinessObjectImpl;

    @Mock
    @Test
    public void testStudentsByClass() {

        Student student1 = new Student("Joy Ma", "Spanish");
        Student student2 = new Student("Julio Hernandez", "Algebra");
        Student student3 = new Student("Jenny Jones", "Calculus");
        List<Student> allStudents = Arrays.asList(student1, student2, student3);

        given(studentDataObject.getAllStudents()).willReturn(allStudents);

        List<String> mathStudents = clientBusinessObjectImpl.getAllStudentsBySubject("math");

        assertThat(mathStudents.size().is(2));
        assertThat(mathStudents, hasItems(student3, student2);
    }

    @Test
    public void testMarkInactive(){

        Class geo = new Class("Geometry", "Summer 2022");
        Class environment = new Class("Environmental Science", "Fall 2022");
        Class literature = new Class("Comparative Literature", "Spring 2023");

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        clientBusinessObjectImpl.markCurrentClassesInactive();

        verify(classDataObject, Mockito.never()).markInactive(geo);
        verify(classDataObject, Mockito.never()).markInactive(environment);
        verify(classDataObject, Mockito.never(1)).markInactive(literature);
    }

    @Captor
    ArgumentCaptor<Class> classArgumentCaptor;

    @Test
    public void testMarkInactive_argumentCaptor(){
        Class geo = new Class("Geometry", "Summer 2022");
        Class environment = new Class("Environmental Science", "Fall 2022");
        Class literature = new Class("Comparative Literature", "Spring 2023");
        List<Class> allClasses = Arrays.asList(geo, environment, literature);

        given(classDataObject.getAllClasses()).willReturn(allClasses);

        clientBusinessObjectImpl.markCurrentClassesInactive();

        verify(classDataObject).markInactive(classArgumentCaptor.capture());
        assertEquals(geo, classArgumentCaptor.getValue());
    }

    @Test
    public void getClassesByInstructor(String String int){
        Instuctor instructorId1 = new Instuctor("Ben", "Geometry", 2);
        Instuctor instructorId2 = new Instuctor("James", "Environmental Science", 3);
        Instuctor instructorId3 = new Instuctor("William", "Comparative Literature", 1);
        List<Instuctor> allInstructors = Arrays.asList(instructor1, instructor2, instructor3);

        List<String> instructorIdWith2 = InstructorDataObject.getClassesByInstructor(2);

        assertThat(instructorIdWith2.size().is(2));
        assertThat(instructorIdWith2, hasItems(instructorId1);
    }

    @Test
    public void getStudentsInClass(){
        Class geoId = new Class(3);
        Class environmentId = new Class(2);
        Class literatureId = new Class(1);
        List<Class> classesById = Arrays.asList(geoId, environmentId, literatureId);

        given(classDataObject.getStudentInClass()).willReturn(classesById);

        List<String> classIdWith3 = classDataObject.getStudentsInClass(3)

        assertThat(classIdWith3.size().is(3));
        assertThat(classIdWith3, hasItems(geoId);
    }
}
