public interface IVooRepository extends CrudRepository<Voo, Long> {
    List<Voo> findByTitle(String title);
}