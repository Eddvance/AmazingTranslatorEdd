package io.eddvance.practice.translatorAmazing.repository;

import io.eddvance.practice.translatorAmazing.entite.Translation;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class FrenchTranslationRepository implements TranslationRepositoryInterface {


    @Override
    public List<Translation> findByLanguage(String language) {
        return List.of();
    }

    @Override
    public List<Translation> findByLanguageOrderByPosition(String language) {
        return List.of();
    }

    @Override
    public Translation findByLanguageAndPosition(String language, int position) {
        return null;
    }

    @Override
    public List<Translation> findByLanguageOrderByPositionAsc(String language) {
        return List.of();
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Translation> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Translation> List<S> saveAllAndFlush(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public void deleteAllInBatch(Iterable<Translation> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Long> longs) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    /**
     * @param aLong
     * @deprecated
     */
    @Override
    public Translation getOne(Long aLong) {
        return null;
    }

    /**
     * @param aLong
     * @deprecated
     */
    @Override
    public Translation getById(Long aLong) {
        return null;
    }

    @Override
    public Translation getReferenceById(Long aLong) {
        return null;
    }

    @Override
    public <S extends Translation> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Translation> List<S> findAll(Example<S> example) {
        return List.of();
    }

    @Override
    public <S extends Translation> List<S> findAll(Example<S> example, Sort sort) {
        return List.of();
    }

    @Override
    public <S extends Translation> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Translation> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Translation> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Translation, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Translation> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Translation> List<S> saveAll(Iterable<S> entities) {
        return List.of();
    }

    @Override
    public Optional<Translation> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public List<Translation> findAll() {
        return List.of();
    }

    @Override
    public List<Translation> findAllById(Iterable<Long> longs) {
        return List.of();
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Translation entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Long> longs) {

    }

    @Override
    public void deleteAll(Iterable<? extends Translation> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Translation> findAll(Sort sort) {
        return List.of();
    }

    @Override
    public Page<Translation> findAll(Pageable pageable) {
        return null;
    }
}

